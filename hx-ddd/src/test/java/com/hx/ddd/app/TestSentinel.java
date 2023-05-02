package com.hx.ddd.app;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSentinel {
    @SneakyThrows
    @Test
    public void name() {
        //加载流控规则
        initFlowRules();

        for (int i = 0; i < 5; i++) {
            Entry entry = null;
            try {
                entry = SphU.entry("sayHello");
                //被保护的逻辑
                System.out.println("访问sayHello资源");
                Thread.sleep(1000);
            } catch (BlockException ex) {
                System.out.println("被流量控制了，可以进行降级处理");
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }
    }

    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();

        //创建一个流控规则
        FlowRule rule = new FlowRule();
        //对sayHello这个资源限流
        rule.setResource("sayHello");
        //基于qps限流
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //qps最大为2，超过2就要被限流
        rule.setCount(3);

        rules.add(rule);

        //设置规则
        FlowRuleManager.loadRules(rules);
    }
}
