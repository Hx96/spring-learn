package org.hx.spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XingHuang
 */
public class HxApplicationContext {
    private Class<?> configClass;

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ArrayList<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();


    public HxApplicationContext(Class<?> configClass, Class <?> runClass) {
        this.configClass = configClass;

        // 扫描 ----> 定义BeanDefinition ------》 BeanDefinitionMap
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScanAnnotation = configClass.getAnnotation(ComponentScan.class);
            // org.hx.service
            String path = componentScanAnnotation.value();
            // org/hx/service
            path = path.replace(".", "/");
            ClassLoader classLoader = HxApplicationContext.class.getClassLoader();
            // 相对路径的资源
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());
            if (file.isDirectory()) {
                File[] files = getFiles(file);
                processBeanDefinition(classLoader, files);
            }
        }

        // 创建单例bean
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }

    }

    private void processBeanDefinition(ClassLoader classLoader, File[] files) {
        for (File f : files) {
            String fileName = f.getAbsolutePath();
            if (fileName.endsWith("class")) {
                // 类的加载
                try {
                    // fileName 进行分割包名 org.hx
                    Class<?> clazz = getClazz(classLoader, fileName);
                    generateBeanDefinition(clazz);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException();
                }
            }
        }
    }

    private void generateBeanDefinition(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Component.class)) {
            // 处理BeanPostProcessor
            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                try {
                    BeanPostProcessor instance = (BeanPostProcessor) clazz.newInstance();
                    beanPostProcessorList.add(instance);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            // Bean 这里定义了一个Bean
            // 生成一个BeanDefinition
            BeanDefinition beanDefinition = new BeanDefinition();
            String beanName = clazz.getAnnotation(Component.class).value();
            if ("".equals(beanName)) {
                beanName = Introspector.decapitalize(clazz.getSimpleName());
            }
            beanDefinition.setType(clazz);
            if (clazz.isAnnotationPresent(Scope.class)) {
                String scope = clazz.getAnnotation(Scope.class).value();
                beanDefinition.setScope(scope);
            } else {
                beanDefinition.setScope("singleton");
            }
            beanDefinitionMap.put(beanName, beanDefinition);
        }
    }

    private Class<?> getClazz(ClassLoader classLoader, String fileName) throws ClassNotFoundException {
        String className = fileName.substring(fileName.indexOf("org"), fileName.indexOf(".class"));
        className = className.replace("\\", ".");
        return classLoader.loadClass(className);
    }

    private File[] getFiles(File file) {
        File[] files = file.listFiles();
        assert files != null;
        return files;
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        try {
            Class<?> clazz = beanDefinition.getType();
            Object instance = clazz.getConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    field.setAccessible(true);
                    field.set(instance, getBean(field.getName()));
                }
            }
            // aware
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }

            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                beanPostProcessor.postProcessBeforeInitialization(beanName, instance);
            }
            // 初始化
            if (instance instanceof InitializeBean) {
                ((InitializeBean) instance).afterPropertiesSet();
            }
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                beanPostProcessor.postProcessAfterInitialization(beanName, instance);
            }

            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getBean(String beanName) {
        // beanName 根据名字判断单例，多例模式
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new RuntimeException();
        } else {
            String scope = beanDefinition.getScope();
            if ("singleton".equals(scope)) {
                Object bean = singletonObjects.get(beanName);
                if (bean == null) {
                    Object o = createBean(beanName, beanDefinition);
                    singletonObjects.put(beanName, o);
                }
                return bean;
            } else {
                return createBean(beanName, beanDefinition);
            }
        }
    }
}
