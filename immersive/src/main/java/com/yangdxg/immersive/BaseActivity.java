package com.yangdxg.immersive;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toolbar;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/13.
 * 功能：
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //5.0以上使用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //状态栏
            getWindow().setStatusBarColor(Color.GREEN);
            //虚拟键盘(底部虚拟导航栏)
            getWindow().setNavigationBarColor(Color.GREEN);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //4.4以上实现
            //设置全屏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * @param toolBarView 最顶部View
     * @param bottomView
     * @param styleColor
     */
    public void setToolBarStyle(View toolBarView, View bottomView, int styleColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //4.4-5.0
            //1.先拿到状态栏高度
            int statusHeight = getStatusHeight();
            toolBarView.setPadding(0, toolBarView.getPaddingTop() + statusHeight, 0, 0);
            //底部虚拟键盘填充
            ViewGroup.LayoutParams layoutParams = bottomView.getLayoutParams();
            //获取虚拟键盘导航栏高度
            int navigationHeight = hasNavigation();
            layoutParams.height += navigationHeight;
            bottomView.setLayoutParams(layoutParams);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0
        } else {
            //4.4一下，不做考虑
        }
    }


    /**
     * 使用反射获取状态栏高度
     *
     * @return
     */
    private int getStatusHeight() {
        int height = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            String status_bar_height = clazz.getField("status_bar_height").get(object).toString();
            height = Integer.parseInt(status_bar_height);
            height = getResources().getDimensionPixelSize(height);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return height;
    }

    /**
     * 判断是否有虚拟键盘（虚拟导航栏）
     * 判断真实宽高是否大于显示宽高
     *
     * @return
     */
    private int hasNavigation() {
        Display display = getWindowManager().getDefaultDisplay();

        DisplayMetrics realDisplayMetrics = new DisplayMetrics();
        DisplayMetrics displayMetrics = new DisplayMetrics();

        //真实宽高
        display.getRealMetrics(realDisplayMetrics);
        //显示宽高，去除虚拟键盘后的高度
        display.getMetrics(displayMetrics);

        int realHeight = realDisplayMetrics.heightPixels;
        int height = displayMetrics.heightPixels;

        if (realHeight - height > 0) {
            return realHeight - height;
        } else {
            return 0;
        }

    }


    /**
     * 使用反射获取底部虚拟键盘高度
     *
     * @return
     */
    private int getNavigationHeight() {
        int height = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            String status_bar_height = clazz.getField("navigation_bar_height").get(object).toString();
            height = Integer.parseInt(status_bar_height);
            height = getResources().getDimensionPixelSize(height);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return height;
    }
}
