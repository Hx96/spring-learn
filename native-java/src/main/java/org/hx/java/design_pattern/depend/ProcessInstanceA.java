package org.hx.java.design_pattern.depend;

/**
 * 过程instancea
 *
 * @author kyle
 * @date 2022/12/24
 */
public class ProcessInstanceA implements DefaultProcess {
    @Override
    public void process(String param) {
        System.out.println("子类A called");
    }
}
