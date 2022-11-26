package org.hx.java.design_pattern.stratege;

/**
 * @author kyle
 */
public abstract class SalaryCalculator {

    /**
     * 计算工资直接进行输出
     * @param context
     */
    void eval(Context context) {
        System.out.print("策略薪资计算: ");
    }
}
