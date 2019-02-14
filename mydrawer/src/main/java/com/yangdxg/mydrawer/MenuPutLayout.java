package com.yangdxg.mydrawer;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/14.
 * 功能： 完成线性布局和背景的组合
 */

public class MenuPutLayout extends RelativeLayout {

    private MenuBgView mMenuBgView;
    private MenuContentLayout mContentLayout;

    public MenuPutLayout(Context context, MenuContentLayout contentLayout) {
        this(context, null, contentLayout);
    }

    public MenuPutLayout(Context context, AttributeSet attrs, MenuContentLayout contentLayout) {
        this(context, attrs, 0, contentLayout);
    }

    public MenuPutLayout(Context context, AttributeSet attrs, int defStyleAttr, MenuContentLayout contentLayout) {
        super(context, attrs, defStyleAttr);
        this.mContentLayout = contentLayout;
        init();
    }

    public void init() {
        //转移LinearLayout的宽高给当前
        setLayoutParams(mContentLayout.getLayoutParams());
        //把背景添加进来
        mMenuBgView = new MenuBgView(getContext());
        mMenuBgView.setColor(mContentLayout.getBackground());
        //设置背景透明
        mContentLayout.setBackgroundColor(Color.TRANSPARENT);
        addView(mMenuBgView);
        addView(mContentLayout, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void setTouchY(float y, float precent) {
        mMenuBgView.setTouchY(y, precent);
        mContentLayout.setTouchY(y, precent);
    }

}
