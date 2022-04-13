package context;

import beans.support.GpBeanDefinitionReader;
import beans.support.config.GpBeanDefinition;

import java.util.List;

/**
 * Application
 * @author XingHuang
 */
public class GpApplicationContext <T> {

    String [] configLocations;
    GpBeanDefinitionReader gpBeanDefinitionReader;

    public GpApplicationContext() {
        // 1 加载配置文件
        gpBeanDefinitionReader = new GpBeanDefinitionReader();
        // 2 解析配置文件封装成BeanDefinition
        List<GpBeanDefinition> gpBeanDefinitionList = gpBeanDefinitionReader.loadBeanDefinitions();
        // 3 缓存起来
        doRegistBeanDefinition(gpBeanDefinitionList);
        // 4 不延时加载
        doAutowirted();
    }

    private void doAutowirted() {
        // 调用getBean触发
    }

    private void doRegistBeanDefinition(List<GpBeanDefinition> gpBeanDefinitionList) {

    }

    public Object getBean(String beanName){
        return null;
    }

    public Object getBean(Class<T> beanClass){
        return null;
    }
}
