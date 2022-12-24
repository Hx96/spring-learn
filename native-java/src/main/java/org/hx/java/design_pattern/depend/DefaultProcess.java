package org.hx.java.design_pattern.depend;

/**
 * 默认过程
 *
 * @author kyle
 * @date 2022/12/24
 */
public interface DefaultProcess<T extends PublicProcess> extends Process {

    /**
     * 先调用模板，再调用子类实现
     *
     * @param defaultParam 默认参数
     * @param param        参数
     */
    default void process(String defaultParam, String param, T t) {
        System.out.println("default called: " + defaultParam);
        t.doPublic();
        process(param);
    }
}
