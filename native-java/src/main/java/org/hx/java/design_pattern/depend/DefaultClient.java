package org.hx.java.design_pattern.depend;

public class DefaultClient {
    public static void main(String[] args) {
        DefaultProcess pa = new ProcessInstanceA();
        DefaultProcess pb = new ProcessInstanceB();
        pa.process("hx","do");
        pb.process("zs","do");
    }
}
