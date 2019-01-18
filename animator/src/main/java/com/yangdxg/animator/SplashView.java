package com.yangdxg.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

/**
 * 作者： yangdongxing
 * 日期： 2019/1/17.
 * 功能：
 */

public class SplashView extends View {

    ValueAnimator mAnimator = null;
    //动画执行总时间
    private long mSplashDuration = 1200;
    //当前大圆旋转角度（弧度）
    private float mCurrentRotationAngle = 0F;
    //旋转动画时间
    private long mRotationDuration = 1200;
    //背景颜色
    private int mSplashBgColor = Color.WHITE;
    //圆圈颜色数组
    private int[] mCircleColors = {};
    //圆圈半径
    private float mRotationRadius = 90;
    //聚合动画中圆圈半径
    private float mCurrentRotationRadius = mRotationRadius;

    //屏幕中心坐标点
    private float mCenterX;
    private float mCenterY;
    //小圆的半径
    private float mCircleRadius = 18;
    //屏幕对角线一半
    private float mDiagonalDist;

    private Paint mPaint;
    private float mHoleRadius;
    private Paint mPaintBackground;


    public SplashView(Context context) {
        this(context, null);
    }

    public SplashView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SplashView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        mCircleColors = context.getResources().getIntArray(R.array.splash_circle_colors);
        mPaint = new Paint();
        mPaintBackground = new Paint();
        //仅描边
        mPaintBackground.setStyle(Paint.Style.STROKE);
        mPaintBackground.setColor(mSplashBgColor);
        //抗锯齿
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCenterX = w / 2;
        mCenterY = h / 2;
        //勾股定理计算对角线的长度
        mDiagonalDist = (float) (Math.sqrt(w * w + h * h) / 2f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mState == null) {
            mState = new RotateState();
        }
        //先绘制旋转
        mState.drawState(canvas);
    }

    /**
     * 进行状态转换
     */
    public void splashDisappear() {
        if (mState != null && mState instanceof RotateState) {
            mState.cancle();
            post(new Runnable() {
                @Override
                public void run() {
                    mState = new MerginState();
                }
            });
        }
    }

    SplashState mState = null;

    /**
     * 策略模式（状态模式）,每一种状态是一个绘制
     */
    private abstract class SplashState {
        public abstract void drawState(Canvas canvas);

        public void cancle() {
            mAnimator.cancel();
        }
    }

    /**
     * 旋转动画
     */
    private class RotateState extends SplashState {

        public RotateState() {
            //0-360度
            mAnimator = ValueAnimator.ofFloat(0f, (float) (Math.PI * 2));
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentRotationAngle = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            //创建线性插值器，迅速进行
            mAnimator.setInterpolator(new LinearInterpolator());
            mAnimator.setDuration(mRotationDuration);
            //无限循环
            mAnimator.setRepeatCount(ValueAnimator.INFINITE);
            mAnimator.start();
        }

        @Override
        public void drawState(Canvas canvas) {
            drawBackground(canvas);
            drawCircles(canvas);
        }

    }

    /**
     * 画背景
     *
     * @param canvas
     */
    private void drawBackground(Canvas canvas) {
        if (mHoleRadius > 0) {
            float strokeWidth = mDiagonalDist - mHoleRadius;
            mPaintBackground.setStrokeWidth(strokeWidth);

            float radius = mHoleRadius + strokeWidth / 2;
            canvas.drawCircle(mCenterX, mCenterY, radius, mPaintBackground);
        } else {
            canvas.drawColor(mSplashBgColor);
        }
    }

    /**
     * 画圆
     */
    private void drawCircles(Canvas canvas) {
        //x=r*cons(a)+centerX
        //y=r*sina(a)+centerY
        //1.周长
        float rotationAngle = (float) (2 * Math.PI / mCircleColors.length);
        for (int i = 0; i < mCircleColors.length; i++) {
            //计算每个小圆的角度
            double angle = i * rotationAngle + mCurrentRotationAngle;
            //计算每个小圆的圆心
            float cx = (float) (mCurrentRotationRadius * Math.cos(angle) + mCenterX);
            float cy = (float) (mCurrentRotationRadius * Math.sin(angle) + mCenterY);

            mPaint.setColor(mCircleColors[i]);
            canvas.drawCircle(cx, cy, mCircleRadius, mPaint);
        }
    }

    /**
     * 聚合动画
     */
    private class MerginState extends SplashState {

        public MerginState() {
            mAnimator = ValueAnimator.ofFloat(mRotationRadius, 0);
            mAnimator.setDuration(mRotationDuration);
            //张力插值器，扩散反弹一下
            mAnimator.setInterpolator(new OvershootInterpolator(10));
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentRotationRadius = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            mAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mState = new ExpandState();
                }
            });
            mAnimator.reverse();
        }

        @Override
        public void drawState(Canvas canvas) {
            drawBackground(canvas);
            drawCircles(canvas);
        }
    }

    /**
     * 扩散动画
     */
    private class ExpandState extends SplashState {

        public ExpandState() {
            mAnimator = ValueAnimator.ofFloat(mCircleRadius, mDiagonalDist);
            mAnimator.setDuration(mRotationDuration);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mHoleRadius = (float) animation.getAnimatedValue();
                    invalidate();
                }
            });
            mAnimator.start();
        }

        @Override
        public void drawState(Canvas canvas) {
            drawBackground(canvas);
        }
    }

}
