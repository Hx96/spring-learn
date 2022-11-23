package org.hx.java.design_pattern.abstract_factory;

/**
 * 多套方案，不同的家族库
 */
interface AbstractFactory {

    /**
     * 创建产品A
     *
     * @return
     */
    AbstractProductA createProductA();


    /**
     * 创建产品B
     *
     * @return
     */
    AbstractProductB createProductB();


}

interface AbstractProductA {
    void printFacade();
}

class ProductA1 implements AbstractProductA {

    @Override
    public void printFacade() {
        System.out.println("产品A1外观黄色");
    }
}

class ProductB1 implements AbstractProductB {

    @Override
    public void show() {
        System.out.println("B1");
    }
}

class ProductA2 implements AbstractProductB {

    @Override
    public void show() {
        System.out.println("B2");
    }
}

class ConcreteFactory1 implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}


interface AbstractProductB {
    void show();
}

/**
 * @author kyle
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory concreteFactory1 = new ConcreteFactory1();
        AbstractProductA productA = concreteFactory1.createProductA();
        AbstractProductB productB = concreteFactory1.createProductB();
        productA.printFacade();
        productB.show();
    }
}
