package com.yangdxg.myrecyclerview;

import android.view.View;
import android.view.ViewGroup;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/14.
 * 功能：
 */

public interface Adapter {

    /**
     * 布局类型
     *
     * @param row
     * @return
     */
    int getItemViewType(int row);

    /**
     * item类型数量
     *
     * @return
     */
    int getViewTypeCount();

    View getView(int position, View convertView, ViewGroup parent);

    int getCount();

    int getHeight(int index);
}
