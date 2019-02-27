package com.yangdxg.pattern;

import android.util.Log;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/21.
 * 功能：
 */

public class Factory {
    private static final String TAG = "Factory";

    /**
     * 动物接口
     */
    interface Animal {
        void move();
    }

    /**
     * Cat类
     */
    public static class Cat implements Animal {
        @Override
        public void move() {
            Log.e(TAG, "move: 小猫滚");
        }

        public void eatFish() {
            Log.e(TAG, "eatFish: 猫吃鱼");
        }
    }

    /**
     * Dog类
     */
    public static class Dog implements Animal {

        @Override
        public void move() {
            Log.e(TAG, "move: 小狗滚");
        }

        public void eatBone() {
            Log.e(TAG, "eatBone: 狗吃骨头");
        }
    }

    /**
     * 工厂模式
     * 多出调用，不需要实例工厂类
     */
    public static class MyFactory {
        public static Cat productCat() {
            return new Cat();
        }

        public static Dog productDog() {
            return new Dog();
        }
    }

    //使用
//    Animal cat = Factory.produceCat();
//    cat.move();
//    Dog dog = Factory.produceDog();
//    dog.move();
//    dog.eatBone();

    /**
     * 工厂模式
     * 定义一个用于创建对象的接口，让子类决定实例化哪个类，工厂模式使一个类的实例化延迟到其子类，对同一个接口的实现类进行管理和实例化创建
     */


    /**
     * 生产接口provider
     */
    interface Provider {
        Animal produce();
    }

    /**
     * 每个产品都有自己的工厂
     */
    public class CatFactory implements Provider {

        @Override
        public Animal produce() {
            return new Cat();
        }
    }

    public class DogFactory implements Provider {

        @Override
        public Animal produce() {
            return new Dog();
        }
    }

    /**
     * 产品生产
     */
    public void init() {
        Provider provider = new CatFactory();
        Animal cat = provider.produce();
        cat.move();
    }
    /**
     * 把生产抽象成一个接口，每个实例类都对应一个工厂类（普通工厂只有一个工厂类），同时所有工厂类都继承这个生产接口。
     * Android 中用到的工厂模式，AsyncTask（抽）
     */
}
