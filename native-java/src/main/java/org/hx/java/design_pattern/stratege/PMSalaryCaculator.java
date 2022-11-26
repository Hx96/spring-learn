package org.hx.java.design_pattern.stratege;

public class PMSalaryCaculator extends SalaryCalculator {
    @Override
    public void eval(Context context) {
        super.eval(context);
        System.out.println("PM计算: " + (200 + 300 * context.getPerformance()));
    }
}
