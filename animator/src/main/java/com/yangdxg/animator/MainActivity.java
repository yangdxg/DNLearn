package com.yangdxg.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mMainView;
    private SplashView mSplashView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //将动画层盖在实际的操作图层上
        mMainView = new FrameLayout(this);
        ContentView contentView = new ContentView(this);
        mMainView.addView(contentView);
        mSplashView = new SplashView(this);
        mMainView.addView(mSplashView);
        setContentView(mMainView);
        startLoadData();
    }

    Handler handler = new Handler();

    private void startLoadData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //数据加载完毕，进入主界面--->开启后面的两个动画
                mSplashView.splashDisappear();
            }
        }, 5000);//延迟时间
    }


    public void alphaClick(View view) {
        startObjectAnimatorAnim(view);
    }

    public void scaleClick(View view) {
        startValueAnimatorAnim(view);
    }

    public void propertyClick(View view) {
        startPropertyValueHolderAnim(view);
    }

    public void animatorSetClick(View view) {
        startAnimatorSet(view);
    }

    public void evaluatorSetClick(View view) {
        startEvaluator(view);
    }

    /**
     * ObjectAnimator基本使用继承子ValueAnimator
     * 对对象v的alpha参数进行操作，alpha的值从1.0变到0.3
     *
     * @param v
     */
    public void startObjectAnimatorAnim(View v) {
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(v, "alpha", 1.0f, 0.3f);
        //执行事件
        alphaAnim.setDuration(1000);
        //延迟
        alphaAnim.setStartDelay(300);
        alphaAnim.start();
    }

    /**
     * 在一段时间内生成连续的值完成view的缩放
     *
     * @param v
     */
    public void startValueAnimatorAnim(final View v) {
        //不改变属性大小，只在一段事件内生成连续的值
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 100f);
        animator.setDuration(500);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //百分比对应的值
                float value = (float) animation.getAnimatedValue();
                Log.e("TAG", "onAnimationUpdate: " + value);
                v.setScaleX(0.5f + value / 200);
                v.setScaleY(0.5f + value / 200);
            }
        });
        animator.start();
    }

    /**
     * 一个动画实现多个效果的变换
     *
     * @param v
     */
    public void startPropertyValueHolderAnim(View v) {
        PropertyValuesHolder alphaProper = PropertyValuesHolder.ofFloat("alpha", 0.5f, 1f);
        PropertyValuesHolder scaleXProper = PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1f);
        PropertyValuesHolder scaleYProper = PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1f);
        ValueAnimator animator = ObjectAnimator.ofPropertyValuesHolder(v, alphaProper, scaleXProper, scaleYProper);
        animator.setDuration(500);
        animator.start();
    }

    /**
     * 执行多个动画并控制动画顺序
     *
     * @param v
     */
    public void startAnimatorSet(View v) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(v, "translationX", 0f, 100f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(v, "scaleX", 0f, 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        //动画1，2同时执行
        animatorSet.play(animator1).with(animator2);
        //动画2执行完成后执行动画3
        animatorSet.play(animator3).after(animator2);
        animatorSet.start();
    }

    /**
     * 使用估值器实现重力下落
     *
     * @param v
     */
    public void startEvaluator(final View v) {
        ValueAnimator animator = new ValueAnimator();
        animator.setDuration(3000);
        animator.setObjectValues(new PointF(0, 0));
        final PointF pointF = new PointF();
        animator.setEvaluator(new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                //fraction是运动中的匀速变化的值
                //根据重力计算实际的运动y=vt=0.5*g*t*t
                //g越大效果越明显
                pointF.x = 100 * (fraction * 5);
                pointF.y = 0.5f * 150f * (fraction * 5) * (fraction * 5);
                return pointF;
            }
        });
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF p = (PointF) animation.getAnimatedValue();
                v.setX(p.x);
                v.setY(p.y);
            }
        });
        //加速查值器，参数越大，速度越来越快
//        animator.setInterpolator(new AccelerateInterpolator(10));
        //减速差值起，和上面相反
//        animator.setInterpolator(new DecelerateInterpolator(10));
        //先加速后减速插值器
//        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        //张力值，默认为2，T越大，初始的偏移越大，而且速度越快
//        animator.setInterpolator(new AnticipateInterpolator(3));
        //张力值tension，默认为2，张力越大，起始时和结束时的偏移越大
//        animator.setInterpolator(new AnticipateOvershootInterpolator(6));
        //弹跳插值器
        animator.setInterpolator(new BounceInterpolator());
        //周期插值器
//        animator.setInterpolator(new CycleInterpolator(2));
        //线性差值器,匀速
//        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }

}
