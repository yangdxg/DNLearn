package com.yangdxg.animframework;

/**
 * 作者： yangdongxing
 * 日期： 2019/1/21.
 * 功能： 接口化解耦合
 */

public interface DiscrollInterface {

    /**
     * 滑动的时候做的具体的事情
     * 执行动画的操作都放在这里
     * @param ratio 动画执行的进度
     */
    void onDiscrool(float ratio);

    void onResetDiscroll();
}
