package com.yangdxg.mydrawer;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/14.
 * 功能： 线性布局完成布局摆放
 */

public class MenuContentLayout extends LinearLayout {

    private float mMaxTranslationX;

    public MenuContentLayout(Context context) {
        this(context, null);
    }

    public MenuContentLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuContentLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        setOrientation(VERTICAL);
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SideBar);
            mMaxTranslationX = a.getDimension(R.styleable.SideBar_maxTranslationX, 0);
            a.recycle();
        }
    }

    public void setTouchY(float y, float precent) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            apply(child, y, precent);

            //设置选中
            child.setPressed(false);
            boolean isHover = precent > 0.8 && y > child.getTop() && y < child.getBottom();
            if (isHover) {
                child.setPressed(true);
            }
        }
    }

    public void apply(View child, float y, float precent) {
        //最终控件x偏移量
        float translationX = 0;
        //计算控件中心点
        float centerY = child.getTop() + child.getHeight() / 2;
        //首先得到手指距离差
        float distance = Math.abs(y - centerY);
        //放大三倍系数
        float scale = distance / getHeight() * 3;
        translationX = mMaxTranslationX - scale* mMaxTranslationX;
        child.setTranslationX(translationX);
    }

    public void onMotionUp() {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.isPressed()) {
                child.performClick();
            }
        }
    }

}
