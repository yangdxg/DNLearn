package com.yangdxg.pattern;

import android.util.Log;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/21.
 * 功能：
 */

public class Adapter {

    private static final String TAG = "Adapter";

    /**
     * 适配器模式
     * 讲一个类的接口装换乘客户希望的另外一个接口，使用Adapter，在这俩中接口之间创建一个混合接口
     * 需要适配的类（Adaptee）
     * 适配器（Adapter）：通过包装一个需要适配的对象，把源接口转换成目标接口
     * 目标接口（Target）：客户所期待的接口，可以是具体的或抽象的类，也可以是接口
     *
     * 优点：跟好的服用，更好的扩展性
     * 缺点：系统凌乱，整体不好把我
     */

    /**
     * 需要适配的类
     */
    class Adaptee {
        public void specificRequest() {
            Log.e(TAG, "specificRequest: 需要适配的类");
        }
    }

    /**
     * 目标接口
     */
    interface Target {
        void request();
    }

    /**
     * 适配器实现目标接口
     * 如果Target不是接口而是一个具体的类，这里的Adapter直接继承Target就可以了
     */
    class MyAdapter implements Target {

        private final Adaptee mAdaptee;

        public MyAdapter(Adaptee adaptee) {
            mAdaptee = adaptee;
        }

        @Override
        public void request() {
            this.mAdaptee.specificRequest();
        }
    }

    /**
     * 类的适配器模式，采用继承实现
     * 如果Target和Adaptee都是接口，并且都有实现类，通过Adapter实现俩个接口来完成适配
     */
    class MyAdapter2 extends Adaptee implements Target {

        @Override
        public void request() {
            super.specificRequest();
        }
    }


    public void test() {
        MyAdapter2 adapter2 = new MyAdapter2();
        adapter2.request();
    }

}
