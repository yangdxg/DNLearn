package com.yangdxg.pattern;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/21.
 * 功能：
 */

public class Singleton {

    /**
     * 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
     * 如果在这里进行初始化就是饿汉式
     */
    private static Singleton instance = null;

    /**
     * 构建私有方法，防止被实例化
     */
    private Singleton() {
    }

    /**
     * 懒汉式，第一次初始化，以后就不再生成了
     *
     * @return
     */
    public static Singleton getInstance() {
        //加个锁，解决不同步问题，可以采用同步方法，也可以采用同步代码块
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
    /**
     * 1。Android中用到Singleton的地方InputMethodManage(软键盘管理)，AccessibilityManage（View获取点击，焦点，文字改变等事件的分发管理），BluetoothOppManager
     * 同步方法的单例CalendarDatabaseHelper
     * 2。Application并不是单例模式，构造方法是共有的，可以创建多个实例，Application只有一个实例是因为构造函数中base是null没有上下文
     *
     *
     */
}
