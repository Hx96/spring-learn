package org.hx.java.design_pattern.stratege;


import java.util.HashMap;
import java.util.Map;

import static org.hx.java.design_pattern.stratege.Template.ENGINEER;
import static org.hx.java.design_pattern.stratege.Template.PM;

class Template {

    public static final String ENGINEER = "engineer";
    public static final String PM = "pm";

    @SuppressWarnings("AlibabaSwitchStatement")
    public int calculate(String job) {
        // 绩效
        int performance = 4;
        // 职级
        int level = 2;
        switch (job) {
            case ENGINEER:
                // 虽然计算薪资时只使用了 绩效 作为参数, 但是从上下文中都是很容易获取的
                return 100 + 200 * performance;
            case PM:
                // .... 其余代码省略
                return 200 + 300 * performance;
        }
        return 0;
    }
}

class StrategyTemplate {

    private static Map<String, SalaryCalculator> strategyMap = new HashMap<>();

    {
        strategyMap.put(PM, new PMSalaryCaculator());
        strategyMap.put(Template.ENGINEER, new EngineerSalaryCaculator());
    }

    public int calculate(String job) {
        // 绩效
        int performance = 4;
        // 职级
        int level = 2;
        // 只传递了需要 performance 参数
        Context context = new Context();
        context.setPerformance(performance);
        strategyMap.get(job).eval(context);
        return 0;
    }
}


/**
 * @author kyle
 */
public class Client {
    public static void main(String[] args) {
        Template template = new Template();
        String job = ENGINEER;
        System.out.println("面向过程输出: engineer: " + template.calculate(job));
        StrategyTemplate strategyTemplate = new StrategyTemplate();
        strategyTemplate.calculate(job);

        job = PM;
        System.out.println("面向过程输出: pm: " + template.calculate(job));
        strategyTemplate.calculate(job);

    }
}
