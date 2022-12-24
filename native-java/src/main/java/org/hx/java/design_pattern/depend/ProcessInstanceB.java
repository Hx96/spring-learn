package org.hx.java.design_pattern.depend;

/**
 * 过程instanceb
 *
 * @author kyle
 * @date 2022/12/24
 */
public class ProcessInstanceB implements DefaultProcess {
    @Override
    public void process(String param) {
        System.out.println("进程B called");
    }
}
