package com.yangdxg.animframework;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * 作者： yangdongxing
 * 日期： 2019/1/21.
 * 功能：
 */

public class AnimatorFrameLayout extends FrameLayout implements DiscrollInterface {


    private int mWidth;
    private int mHeight;

    public AnimatorFrameLayout(@NonNull Context context) {
        super(context);
    }

    public AnimatorFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimatorFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 获取所有的相关自定义属性
     */
    //背景颜色变化开始值
    public int mDiscrollveFromBgColor;
    //背景颜色变化结束值
    public int mDiscrollveToBgColor;
    //是否需要透明度动画
    public boolean mDiscrollveAlpha;
    //平移值
    public int mDiscrollveTranslation;
    //是否需要x轴方向缩放
    public boolean mDiscrollveScaleX;
    //是否需要y轴方向缩放
    public boolean mDiscrollveScaleY;

    /**
     * 平移的四个方向
     * 第一位为1表示Top
     * 第二位为1表示Bottom
     * 第四位为1表示Left
     * 第八位为1表示Right
     */
    private static final int TRANSLATION_FROM_TOP = 0x01;
    private static final int TRANSLATION_FROM_BOTTOM = 0x02;
    private static final int TRANSLATION_FROM_LEFT = 0x04;
    private static final int TRANSLATION_FROM_RIGHT = 0x08;
    //颜色估值器，实现颜色渐变
    private ArgbEvaluator mArgbEvaluator = new ArgbEvaluator();

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    public void setDiscrollveFromBgColor(int mDiscrollveFromBgColor) {
        this.mDiscrollveFromBgColor = mDiscrollveFromBgColor;
    }

    public void setDiscrollveToBgColor(int mDiscrollveToBgColor) {
        this.mDiscrollveToBgColor = mDiscrollveToBgColor;
    }

    public void setDiscrollveAlpha(boolean mDiscrollveAlpha) {
        this.mDiscrollveAlpha = mDiscrollveAlpha;
    }

    public void setDiscrollveTranslation(int mDiscrollveTranslation) {
        this.mDiscrollveTranslation = mDiscrollveTranslation;
    }

    public void setDiscrollveScaleX(boolean mDiscrollveScaleX) {
        this.mDiscrollveScaleX = mDiscrollveScaleX;
    }

    public void setDiscrollveScaleY(boolean mDiscrollveScaleY) {
        this.mDiscrollveScaleY = mDiscrollveScaleY;
    }

    @Override
    public void onDiscrool(float ratio) {
        if (mDiscrollveAlpha) {
            setAlpha(ratio);
        }
        if (mDiscrollveScaleX) {
            setScaleX(ratio);
        }
        if (mDiscrollveScaleY) {
            setScaleY(ratio);
        }

        //平移动画有四个方向，这四个方向
        if (isTranslationFrom(TRANSLATION_FROM_TOP)) {
            setTranslationY(mHeight * (1 + ratio));
        }
        if (isTranslationFrom(TRANSLATION_FROM_BOTTOM)) {
            setTranslationY(mHeight * (1 - ratio));
        }
        if (isTranslationFrom(TRANSLATION_FROM_LEFT)) {
            setTranslationX(mHeight * (1 + ratio));
        }
        if (isTranslationFrom(TRANSLATION_FROM_RIGHT)) {
            setTranslationX(mHeight * (1 - ratio));
        }
        //使用颜色估值器完成颜色渐变
        if (mDiscrollveFromBgColor != -1 && mDiscrollveToBgColor != -1) {
            setBackgroundColor((Integer) mArgbEvaluator.evaluate(ratio, mDiscrollveFromBgColor, mDiscrollveToBgColor));
        }
    }

    @Override
    public void onResetDiscroll() {
        //回复默认
        onDiscrool(0);
    }


    public boolean isTranslationFrom(int translationMask) {
        if (mDiscrollveTranslation == -1) {
            return false;
        }
        return (mDiscrollveTranslation & translationMask) == translationMask;
    }

}
