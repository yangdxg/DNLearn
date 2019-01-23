package com.yangdxg.animframework;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * 作者： yangdongxing
 * 日期： 2019/1/18.
 * 功能：
 */

public class AnimatorLinearlayout extends LinearLayout {

    public AnimatorLinearlayout(@NonNull Context context) {
        this(context, null);
    }

    public AnimatorLinearlayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimatorLinearlayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
    }


    //从UI绘制流程来讲
    //在源码中使用addView添加子View（重写View）

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {

        AnimatorLayoutParams animatorParams = (AnimatorLayoutParams) params;

        //判断xml中有没有使用自定义属性
        if (!isDiscroll(animatorParams)) {
            super.addView(child, params);
        } else {
            AnimatorFrameLayout frameLayout = new AnimatorFrameLayout(getContext());
            frameLayout.addView(child);
            frameLayout.setDiscrollveAlpha(animatorParams.mDiscrollveAlpha);
            frameLayout.setDiscrollveFromBgColor(animatorParams.mDiscrollveFromBgColor);
            frameLayout.setDiscrollveScaleX(animatorParams.mDiscrollveScaleX);
            frameLayout.setDiscrollveScaleY(animatorParams.mDiscrollveScaleY);
            frameLayout.setDiscrollveToBgColor(animatorParams.mDiscrollveToBgColor);
            frameLayout.setDiscrollveTranslation(animatorParams.mDiscrollveTranslation);
            super.addView(frameLayout, animatorParams);
        }
    }

    /**
     * 判断是否使用了自定义属性
     *
     * @param animatorParams
     * @return
     */
    private boolean isDiscroll(AnimatorLayoutParams animatorParams) {
        return animatorParams.mDiscrollveAlpha ||
                animatorParams.mDiscrollveScaleX ||
                animatorParams.mDiscrollveScaleY ||
                animatorParams.mDiscrollveTranslation != -1 ||
                (animatorParams.mDiscrollveFromBgColor != -1 &&
                        animatorParams.mDiscrollveToBgColor != -1);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new AnimatorLayoutParams(getContext(), attrs);
    }

    public class AnimatorLayoutParams extends LinearLayout.LayoutParams {

        //背景颜色变化开始值
        private int mDiscrollveFromBgColor;
        //背景颜色变化结束值
        private int mDiscrollveToBgColor;
        //是否需要透明度动画
        private boolean mDiscrollveAlpha;
        //平移值
        private int mDiscrollveTranslation;
        //是否需要x轴方向缩放
        private boolean mDiscrollveScaleX;
        //是否需要y轴方向缩放
        private boolean mDiscrollveScaleY;

        /**
         * 获取自定义属性
         *
         * @param c
         * @param attrs
         */
        public AnimatorLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.DiscrollView_LayoutParams);
            mDiscrollveAlpha = a.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_alpha, false);
            mDiscrollveScaleX = a.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_scaleX, false);
            mDiscrollveScaleY = a.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_scaleY, false);
            mDiscrollveFromBgColor = a.getColor(R.styleable.DiscrollView_LayoutParams_discrollve_fromBgColor, -1);
            mDiscrollveToBgColor = a.getColor(R.styleable.DiscrollView_LayoutParams_discrollve_toBgColor, -1);
            mDiscrollveTranslation = a.getInt(R.styleable.DiscrollView_LayoutParams_discrollve_translation, -1);
            a.recycle();
        }
    }

}

