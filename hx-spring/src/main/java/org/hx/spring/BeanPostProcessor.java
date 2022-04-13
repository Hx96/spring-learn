package org.hx.spring;

/**
 * @author XingHuang
 */
public interface BeanPostProcessor {
    /**
     * bean初始化之前do
     * @param beanName
     * @param bean
     */
    public void postProcessBeforeInitialization(String beanName, Object bean);

    /**
     * bean初始化之后do
     * @param beanName
     * @param bean
     */
    public void postProcessAfterInitialization(String beanName, Object bean);
}
