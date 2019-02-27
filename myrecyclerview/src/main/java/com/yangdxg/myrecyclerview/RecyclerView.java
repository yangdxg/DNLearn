package com.yangdxg.myrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/14.
 * 功能：
 */

public class RecyclerView extends ViewGroup {

    private Adapter mAdapter;
    /**
     * y偏移量，Recycler滚动出屏幕的距离
     */
    private int mScrollY;
    /**
     * 当前显示的View
     */
    private List<View> mViewList;

    /**
     * 行数
     */
    private int mRowCount;
    /**
     * 每个item的高度
     */
    private int[] mItemHeights;
    /**
     * 初始化
     */
    private boolean mNeedRelayout;
    /**
     * RecyclerView的宽高
     */
    private int mWidth;
    private int mHeight;
    /**
     * 滑到第几行，可见的第一行，内容中的第几行，
     */
    private int mFirstRow;
    /**
     * 回收栈，二维数组
     */
    private Recycler mRecycler;
    /**
     * 最小滑动距离
     * 28-40
     */
    private int mScaledTouchSlop;
    private int mCurrentY;

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.mViewList = new ArrayList<>();
        this.mNeedRelayout = true;
        ViewConfiguration configuration = ViewConfiguration.get(getContext());
        mScaledTouchSlop = configuration.getScaledTouchSlop();
    }

    /**
     * 添加适配器
     *
     * @param adapter
     */
    public void setAdapter(Adapter adapter) {
        mAdapter = adapter;
        if (mAdapter != null) {
            mRecycler = new Recycler(mAdapter.getViewTypeCount());
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //onLayout会执行俩次，只在初始化时进行处理
        if (mNeedRelayout || changed) {
            mNeedRelayout = false;
            mViewList.clear();
            removeAllViews();

            if (mAdapter != null) {
                //摆放子控件
                mWidth = r - l;
                mHeight = b - t;
                int left, top = 0, right, bottom;
                //第一行不是从0开始
                top = -mScrollY;
                for (int i = 0; i < mRowCount && top < mHeight; i++) {
                    bottom = top + mItemHeights[i];
                    //生成View
                    View view = makeAndStep(i, 0, top, mWidth, bottom);
                    mViewList.add(view);
                    top = bottom;
                }
            }
        }
    }

    private View makeAndStep(int row, int left, int top, int right, int bottom) {
        //实例化一个有宽度，高度的View
        View view = obtainView(row, right - left, bottom - top);
        //设置位置
        view.layout(left, top, right, bottom);
        return view;
    }

    /**
     * item有几个类型，回收池就必须有几个集合
     */

    private View obtainView(int row, int i, int i1) {
        int itemViewType = mAdapter.getItemViewType(row);
        //根据这个类型，返回相应的View（布局）
        //初始化的时候取不到
        View reclyView = mRecycler.getRecyclerView(itemViewType);
        View view = mAdapter.getView(row, reclyView, this);
        if (view == null) {
            throw new RuntimeException("convertView不能为空");
        }
        //View打tag(记录ViewType)
        view.setTag(R.id.tag_type_view, itemViewType);
        view.setTag(R.id.tag_row, row);
        view.measure(MeasureSpec.makeMeasureSpec(mWidth, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(mHeight, MeasureSpec.EXACTLY));
        addView(view, 0);
        return view;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int height = 0;
        if (mAdapter != null) {
            this.mRowCount = mAdapter.getCount();
            mItemHeights = new int[mRowCount];
            for (int i = 0; i < mRowCount; i++) {
                mItemHeights[i] = mAdapter.getHeight(i);
            }
        }
        //所有item高度之和
        int tmpH = sumArray(mItemHeights, 0, mRowCount);
        height = Math.min(heightSize, tmpH);
        setMeasuredDimension(widthMeasureSpec, height);
    }

    /**
     * 拦截滑动事件
     * 预处理事件过程
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mCurrentY = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int move = Math.abs(mCurrentY - (int) ev.getRawY());
                //拦截滑动事件
                if (move > mScaledTouchSlop) {
                    intercept = true;
                }
                break;
        }
        return intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                //移动的距离 y方向
                int y2 = (int) event.getRawY();
                int diffY = mCurrentY - y2;
                scrollBy(0, diffY);
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * x,y代表偏移量
     *
     * @param x
     * @param y
     */
    @Override
    public void scrollBy(int x, int y) {

        mScrollY += y;
        //mScrollY的取值是0到无限大
        //边界值是内容的总高度
        mScrollY = scrollBounds(mScrollY, mFirstRow, mItemHeights, mHeight);
        if (mScrollY > 0) {
            //向上滑动
            while (mItemHeights[mFirstRow] < mScrollY) {
                //item完全移出去
                removeTop();
                //移除之后不能立即把View添加进来
            }
            while (getFilledHeight() < mHeight) {
                addBottom();
            }
            mScrollY -= mItemHeights[mFirstRow];
            mFirstRow++;
        } else if (mScrollY < 0) {
            //向下滑动
//            while (!mViewList.isEmpty() && getFilledHeight() - mItemHeights[mFirstRow + mViewList.size()]) {
            removeBottom();
//            }
            while (0 > mScrollY) {
                addTop();
                mFirstRow--;
                mScrollY += mItemHeights[mFirstRow + 1];
            }
        }
        super.scrollBy(x, y);
    }

    private void removeTop() {
        removeView(mViewList.get(0));
    }

    public int getFilledHeight() {
        return sumArray(mItemHeights, mFirstRow, mViewList.size()) - mScrollY;
    }

    public void addBottom() {
        int size = mViewList.size();
        addTopAndBottom(mFirstRow + size, size);
    }

    public void addTop() {
        addTopAndBottom(mFirstRow - 1, 0);
    }

    public void removeBottom() {
//        removeTopOrBottom(mViewList.size() - 1);
    }

    private void addTopAndBottom(int addRow, int size) {
        View view = obtainView(addRow, mWidth, mItemHeights[addRow]);
        mViewList.add(view);
    }

    /**
     * 修正mScrollY
     *
     * @param scrollY
     * @param firstRow
     * @param sizes
     * @param viewHeight
     * @return
     */
    public int scrollBounds(int scrollY, int firstRow, int sizes[], int viewHeight) {
        if (scrollY > 0) {
            //向上滑动
            //滚动距离不能超过内容总高度
            scrollY = Math.min(scrollY, sumArray(sizes, firstRow, sizes.length - 1));
        } else {
            //向下滑动scrollY是负值，要大于0
            scrollY = Math.max(scrollY, 0);
        }
        return scrollY;
    }

    @Override
    public void removeView(View view) {
        super.removeView(view);
        int typeView = (int) view.getTag(R.id.tag_type_view);
        mRecycler.addRecyclerView(view, typeView);
    }

    /**
     * 对数组指定位数求和
     *
     * @param array
     * @param firstIndex
     * @param count
     * @return
     */
    private int sumArray(int array[], int firstIndex, int count) {
        int sum = 0;
        count += firstIndex;
        for (int i = firstIndex; i < count; i++) {
            sum += array[i];
        }
        return sum;
    }
}

