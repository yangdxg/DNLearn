package com.yangdxg.myrecyclerview;

import android.view.View;

import java.util.Stack;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/14.
 * 功能：
 */

public class Recycler {

    private Stack<View>[] mViews;

    //打造一个回收池
    public Recycler(int typeNumber) {
        //实例化一个栈 数组
        mViews = new Stack[typeNumber];
        for (int i = 0; i < typeNumber; i++) {
            mViews[i] = new Stack<View>();
        }
    }

    public View getRecyclerView(int type) {
        //只关心取到的View是对应的类型
        try {
            return mViews[type].pop();
        } catch (Exception e) {
            return null;
        }
    }

    public void addRecyclerView(View view, int typeView) {
        mViews[typeView].push(view);
    }
}
