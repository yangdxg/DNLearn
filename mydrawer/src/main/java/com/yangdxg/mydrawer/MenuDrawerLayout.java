package com.yangdxg.mydrawer;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/14.
 * 功能： 侧滑菜单，完成事件分发
 */

public class MenuDrawerLayout extends DrawerLayout implements DrawerLayout.DrawerListener {

    private MenuContentLayout mContentLayout;
    private View mContentView;
    private float mY;
    private float mSlideOffset;
    private MenuPutLayout mMenuPutLayout;

    public MenuDrawerLayout(Context context) {
        this(context, null);
    }

    public MenuDrawerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        //先获取在当前侧滑菜单下的俩个控件
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child instanceof MenuContentLayout) {
                mContentLayout = (MenuContentLayout) child;
            } else {
                mContentView = child;
            }
        }

        removeView(mContentLayout);
        mMenuPutLayout = new MenuPutLayout(getContext(), mContentLayout);
        addView(mMenuPutLayout);
        addDrawerListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mY = ev.getY();

        //手指抬起选中关闭菜单
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            closeDrawers();
            mContentLayout.onMotionUp();
            return super.dispatchTouchEvent(ev);
        }

        if (mSlideOffset < 0.8) {
        } else {
            mMenuPutLayout.setTouchY(mY, mSlideOffset);
        }
        return super.dispatchTouchEvent(ev);

    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        mSlideOffset = slideOffset;
        //侧滑系数
        mContentLayout.setTouchY(mY, slideOffset);
        //内容去进行偏移
        float translationX = drawerView.getWidth() * slideOffset / 2;
        mContentView.setTranslationX(translationX);
    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
