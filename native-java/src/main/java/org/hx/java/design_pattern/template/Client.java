package org.hx.java.design_pattern.template;

/**
 * 模板加工厂消除重复代码
 * Cart 购物车
 * VipCart 购物车
 * InnerCart 内部人员购物车
 * @author kyle
 */
public class Client {

    // 重构前

    /**
     * buy方法
     * 1 检查
     * 2 打折
     * 3 计算金额
     * 重复代码1与3
     */

    abstract static class AbstractCart {

        public void buy() {
            // 公共方法check
            System.out.println("do 公共方法");
            System.out.println("打折: " + calculateDisCount() * 0.1);
            // 公共方法计算
        }

        /**
         * 打折，子类进行实现
         *
         * @return {@link Integer}
         */
        public abstract Integer calculateDisCount();
    }

    static class VipCart extends AbstractCart {

        @Override
        public Integer calculateDisCount() {
            System.out.println("VIP 打五折");
            return 5;
        }
    }

    static class InnerCart extends AbstractCart {

        @Override
        public Integer calculateDisCount() {
            System.out.println("内部人员 打7折");
            return 7;
        }
    }

    static class CartFactory {

        public AbstractCart buildVipCart() {
            return new VipCart();
        }

        public AbstractCart buildInnerCart() {
            return new InnerCart();
        }

        public static CartFactory getFactory() {
            return new CartFactory();
        }
    }


    public static void main(String[] args) {
        CartFactory.getFactory().buildInnerCart().buy();
        System.out.println("---------------");
        CartFactory.getFactory().buildVipCart().buy();
    }

}
