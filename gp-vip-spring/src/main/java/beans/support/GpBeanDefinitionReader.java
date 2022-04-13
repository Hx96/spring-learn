package beans.support;

import beans.support.config.GpBeanDefinition;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 *
 * @author XingHuang
 */
public class GpBeanDefinitionReader {
    private String [] configLocations;

    List<String> registryBeanClasses = new ArrayList<>();
    private Properties contextConfig = new Properties();

    public GpBeanDefinitionReader(String... configLocations) {
        this.configLocations = configLocations;
        doLoadConfig(configLocations[0]);
        registryBeanClasses = doScanner();
    }

    private List<String> doScanner() {
        return null;
    }

    public List<GpBeanDefinition> loadBeanDefinitions() {
        ArrayList<GpBeanDefinition> gpBeanDefinitions = new ArrayList<>();
        for (String registryBeanClass : registryBeanClasses) {
            try {
                Class<?> beanClass = Class.forName(registryBeanClass);
                // 保存全类名
                // 1 默认类名首字母小写
                gpBeanDefinitions.add(doCreateBeanDefinition(registryBeanClass,beanClass.getName()));
                // 2 自定义
                // 3 借口注入

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private GpBeanDefinition doCreateBeanDefinition(String registryBeanClass, String beanClass) {
        GpBeanDefinition gpBeanDefinition = new GpBeanDefinition();
        return gpBeanDefinition;
    }

    void doLoadConfig(String contextConfigLocation){
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);

    }
}
