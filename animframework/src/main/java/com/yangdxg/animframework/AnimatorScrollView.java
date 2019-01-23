package com.yangdxg.animframework;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

/**
 * 作者： yangdongxing
 * 日期： 2019/1/21.
 * 功能：
 */

public class AnimatorScrollView extends ScrollView {

    private static final String TAG = "AnimatorScrollView";

    private AnimatorLinearlayout mAnimatorContent;

    public AnimatorScrollView(Context context) {
        this(context, null);
    }

    public AnimatorScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimatorScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //渲染完毕,AnimatorLinearlayout中addView等操作都已完成
        //AnimatorLinearlayout放在了第一层目录下，所以使用getChildAt(0)获取到，根据实际情况获取
        mAnimatorContent = (AnimatorLinearlayout) getChildAt(0);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //开发这种框架，核心的一点是从系统控件上面去获取自定义属性
        //获取到自定义属性之后，根据自己的动画业务进行处理
        //监听滑动
        //到这一节，是否可以调用到动画了
        //监听滑动了多少距离
        //算出一个百分比出来
        for (int i = 0; i < mAnimatorContent.getChildCount(); i++) {
            View child = mAnimatorContent.getChildAt(i);

            if (!(child instanceof DiscrollInterface)) {
                continue;
            }

            Log.e(TAG, "ScrollViewHeight: " + getHeight());
            Log.e(TAG, "ScrollViewTop : " + t);

            DiscrollInterface discrollInterface = (DiscrollInterface) child;
            float radio = 0f;
            //解耦，操作放到子View中
            /**
             * 系数计算
             * 控件漏出的高度/控件的高度=系数
             * 控件漏出的高度=屏幕高度-控件距顶端的距离
             */
            //1.得到当前滑动出来的距离
            int childTop = child.getTop();
            int scrollHeight = getHeight();
            //t是scrollView距顶部的距离
            int absoluteTop = childTop - t;

            if (absoluteTop <= scrollHeight) {
                int visibleHeight = scrollHeight - absoluteTop;
                radio = visibleHeight / (float) child.getHeight();
                discrollInterface.onDiscrool(clamp(radio, 1, 0));
            } else {
                discrollInterface.onResetDiscroll();
            }

        }

    }

    /**
     * 系数必须在0-1之间
     *
     * @param value
     * @param max
     * @param min
     * @return
     */
    private float clamp(float value, float max, float min) {
        return Math.max(Math.min(value, max), min);
    }

}
