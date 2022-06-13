package org.hx.java.design_pattern;

import org.junit.Test;

public class AdaptorClient {

    @Test
    public void main() {
        ThreeElectricOutlet outlet; //目标接口（三相插座）
        Wash wash = new Wash();     //洗衣机
        outlet = wash;              //洗衣机插在三相插座上
        System.out.println("使用三相插座接通电流");
        outlet.connectElectricCurrent();    //接通电流开始洗衣服
        TV tv = new TV();           //电视机
        ThreeElectricAdapter adapter = new ThreeElectricAdapter(tv); //把电视插在适配器上面
        outlet = adapter;           //再把适配器插在三厢插座上
        System.out.println("使用三厢插座接通电流");
        outlet.connectElectricCurrent();  //接通电流，开始播放电视节目
    }

    @Test
    public void main1() {
        ThreeElectricOutlet outlet; //目标接口（三相插座）
        Wash wash = new Wash();     //洗衣机
        outlet = wash;              //洗衣机插在三相插座上
        System.out.println("使用三相插座接通电流");
        outlet.connectElectricCurrent();    //接通电流开始洗衣服
    }

    @Test
    public void main2() {
        TV tv = new TV();           //电视机
        ThreeElectricAdapter adapter = new ThreeElectricAdapter(tv); //把电视插在适配器上面
        System.out.println("使用三厢插座接通电流");
        adapter.connectElectricCurrent();  //接通电流，开始播放电视节目
    }
    interface ThreeElectricOutlet  {
        void connectElectricCurrent();
    }

    interface TwoElectricOutlet {
        void connectElectricCurrent();
    }

    class ThreeElectricAdapter implements ThreeElectricOutlet {
        //适配器包含被适配者的引用
        private TwoElectricOutlet outlet;

        public ThreeElectricAdapter(TwoElectricOutlet outlet) {
            this.outlet = outlet;
        }

        public void connectElectricCurrent() {
            outlet.connectElectricCurrent();
        }

    }

    //洗衣机使用三相插座
    class Wash implements ThreeElectricOutlet{
        private String name;
        public Wash() {
            name = "黄河洗衣机";
        }
        public Wash(String name){
            this.name = name;
        }
        public void connectElectricCurrent() {
            turnOn();
        }
        public void turnOn(){
            System.out.println(name+"开始洗衣服了");
        }

    }

    //电视机使用两厢插座
    class TV implements TwoElectricOutlet{
        private String name;
        public TV() {
            name = "长江电视机";
        }
        public TV(String name){
            this.name = name;
        }
        public void connectElectricCurrent() {
            turnOn();
        }
        public void turnOn(){
            System.out.println(name+"开始播放电视节目");
        }

    }

    @Test
    public  void main3() {
        ThreeElectricOutlet threeOutlet;
        TwoElectricOutlet twOutlet;
        Wash wash = new Wash();
        TV tv = new TV();
        ThreeAndTwoElectricAdapter adapter = new ThreeAndTwoElectricAdapter(wash,tv);
        threeOutlet = adapter;
        System.out.println("使用三厢插座接通电源");
        threeOutlet.connectElectricCurrent();
        twOutlet = adapter;
        System.out.println("使用两厢插座接通电源");
        twOutlet.connectElectricCurrent();
    }

    class ThreeAndTwoElectricAdapter implements ThreeElectricOutlet,
            TwoElectricOutlet {
        private ThreeElectricOutlet threeElectricOutlet;
        private TwoElectricOutlet twoElectricOutlet;

        public ThreeAndTwoElectricAdapter(ThreeElectricOutlet threeOutlet, TwoElectricOutlet twoOutlet) {
            threeElectricOutlet = threeOutlet;
            twoElectricOutlet = twoOutlet;
        }

        public ThreeAndTwoElectricAdapter(TwoElectricOutlet twoOutlet, ThreeElectricOutlet threeOutlet) {
            threeElectricOutlet = threeOutlet;
            twoElectricOutlet = twoOutlet;
        }

        public void connectElectricCurrent() {
            if (this instanceof ThreeElectricOutlet) {
                System.out.println("ThreeElectricOutlet");
                twoElectricOutlet.connectElectricCurrent();//twoElectricOutlet是被适配的接口
            }
            if (this instanceof TwoElectricOutlet) {
                System.out.println("TwoElectricOutlet");
                threeElectricOutlet.connectElectricCurrent(); //threeElectricOutlet是被适配的接口
            }
        }
    }

}
