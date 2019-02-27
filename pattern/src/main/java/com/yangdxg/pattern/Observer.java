package com.yangdxg.pattern;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/21.
 * 功能： 观察者模式
 */

public class Observer {
    private static final String TAG = "Observer";

    /**
     * 一对多的依赖关系，让多个观察者对象同时监听某一个主题对象，对象的状态发生变化时，
     * 会同志所有观察者对象，能更新自己
     * <p>
     * 观察者模式的组成
     * 1。抽象主题（Subject）提供一个接口，可以增加和删除观察者对象
     * 2。具体主题（ConcreteSubject）将有关状态存入具体观察者对象，内部状态改变时，给所有登记过的观察者发出通知
     * 3。抽象观察者（Observer）为所有具体观察者定义一个接口，在得到主题通知时更新自己
     * 4。具体观察者（ConcreteObserver）实现抽象观察者角色要求的更新接口，以便使本身的状态与主题状态协调
     *
     * Android中的应用ContentObserver，DataSetObserver
     */

    /**
     * 抽象观察者
     */
    interface MyObserver {
        void update(String str);
    }

    /**
     * 具体的观察者
     */
    public class ConcreteObserver implements MyObserver {

        @Override
        public void update(String str) {
            Log.e(TAG, "update: " + str);
        }
    }

    /**
     * 抽象主题
     */
    interface Subject {
        void addObserver(MyObserver observer);

        void removeObserver(MyObserver observer);

        void notifyObservers(String str);
    }

    /**
     * 具体主题
     */
    public class ConcreteSubject implements Subject {

        private List<MyObserver> mMyObserverList = new ArrayList<>();

        @Override
        public void addObserver(MyObserver observer) {
            mMyObserverList.add(observer);
        }

        @Override
        public void removeObserver(MyObserver observer) {
            mMyObserverList.remove(observer);
        }

        @Override
        public void notifyObservers(String str) {
            for (MyObserver observer : mMyObserverList) {
                observer.update(str);
            }
        }
    }

    public void test() {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ConcreteObserver observer = new ConcreteObserver();
        ConcreteObserver observer1 = new ConcreteObserver();
        concreteSubject.addObserver(observer);
        concreteSubject.addObserver(observer1);
        concreteSubject.notifyObservers("更新了");
    }

}
