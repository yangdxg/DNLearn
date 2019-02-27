package com.yangdxg.pattern;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/21.
 * 功能： 建造者模式
 */

public class Builder {
    /**
     * 将一个复杂的对象的构建与它的表示分离（同构建不同表示）
     * 将复杂的内部创建封装在内部，对于外部调用的人来说，只需要传入建造者和建造工具
     * 1。Builder：一个抽象接口，用来规范产品对象的各个组成成份的建造
     * 2。ConcreteBuilder：实现Builder接口，针对不同逻辑，具体化复杂对象的各部分的创建，
     * 3。Director：指导者，调用具体建造者来创建复杂对象的各部分
     * 4。Product：要创建的复杂对象
     * <p>
     * 与抽象工厂的区别：在建造者模式里，有个指导者，由指导者来管理建造者，用户食欲指导者联系的
     * 指导者连接建造者得到产品
     * <p>
     * 建造模式可以强制实行一种分步骤进行的建造过程
     *
     * 客户端不必知道产品内部组成的细节。
     * 具体的建造者类之间是相互独立的，对系统的扩展非常有利。
     * 由于具体的建造者是独立的，因此可以对建造过程逐步细化，而不对其他的模块产生任何影响。
     *
     * 创建一些复杂的对象时，这些对象的内部组成构件间的建造顺序是稳定的，但是对象的内部组成构件面临着复杂的变化。
     * 要创建的复杂对象的算法，独立于该对象的组成部分，也独立于组成部分的装配方法时
     *
     * Dialog使用的是建造者模式
     */

    interface Product {

    }

    interface Part {

    }

    interface MyBuilder {
        void buildPartOne();

        void buildPartTwo();

        Product getProduct();
    }

    /**
     * 具体构造工具
     */
    public class ConcreteBuilder implements MyBuilder {

        @Override
        public void buildPartOne() {
            //具体构建代码
        }

        @Override
        public void buildPartTwo() {
            //具体构建代码
        }

        @Override
        public Product getProduct() {
            //返回最后组装的产品
            return null;
        }
    }

    public class Director {

        private final MyBuilder mBuilder;

        public Director(MyBuilder builder) {
            mBuilder = builder;
        }

        public void contruct() {
            mBuilder.buildPartOne();
            mBuilder.buildPartTwo();
        }
    }

    public void test(){
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.contruct();
        Product product = builder.getProduct();
    }
}
