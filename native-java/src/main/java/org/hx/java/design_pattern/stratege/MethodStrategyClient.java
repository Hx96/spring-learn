package org.hx.java.design_pattern.stratege;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kyle
 */
public class MethodStrategyClient {

    interface Strategy {
        /**
         * 函数变成
         */
        void eval();
    }

    public Map<String, Runnable> strategyMap= new HashMap<>();

    {
        strategyMap.put("a", this::aStrategy);
        strategyMap.put("b", this::bStrategy);
    }

    public void aStrategy() {
        System.out.println("a biz run !");
    }

    public void bStrategy() {
        System.out.println("b biz run !");
    }


    public static void main(String[] args) {
        MethodStrategyClient methodStrategyClient = new MethodStrategyClient();
        methodStrategyClient.strategyMap.get("a").run();
        methodStrategyClient.strategyMap.get("b").run();

    }
}
