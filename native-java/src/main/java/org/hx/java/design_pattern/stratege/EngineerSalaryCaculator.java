package org.hx.java.design_pattern.stratege;

public class EngineerSalaryCaculator extends SalaryCalculator {
    @Override
    public void eval(Context context) {
        super.eval(context);
        System.out.println("eng计算： " + (100 + 200 * context.getPerformance()));
    }
}
