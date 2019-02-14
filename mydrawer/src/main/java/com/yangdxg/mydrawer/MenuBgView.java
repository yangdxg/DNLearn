package com.yangdxg.mydrawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/14.
 * 功能： 完成背景
 */

public class MenuBgView extends View {

    private Paint mPaint;
    private Path mPath;

    public MenuBgView(Context context) {
        this(context, null);
    }

    public MenuBgView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuBgView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPath = new Path();
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }

    public void setTouchY(float y, float percent) {
        mPath.reset();
        //偏移量
        float offset = getHeight() / 8;
        //开始点
        float beginX = 0;
        float beginY = -offset;
        //结束点
        float endX = 0;
        float endY = getHeight() + offset;
        //控制点(x坐标是定值，根据drawerlayout滑出的比例计算)
        float controlX = getWidth() * percent * 3 / 2;
        float controlY = y;

        mPath.lineTo(beginX, beginY);
        mPath.quadTo(controlX, controlY, endX, endY);
        mPath.close();
        invalidate();
    }

    public void setColor(int color) {
        mPaint.setColor(color);
    }

    public void setColor(Drawable color) {
//        mPaint.setColord(color);
    }

}
