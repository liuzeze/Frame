package com.lz.utilslib.interceptor.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2016/11/10	10:19	    刘泽			    新增 类
 * 2016/11/10	10:19	    刘泽			    手动创建背景图片
 */
public class LzDrawableUtils {
    /**
     * 动态创建圆角的Drawable，和在xml中使用<shape>一样的
     *
     * @return
     */
    public static Drawable shapeDrawable(int corlor, float[] radius) {
        if (radius == null) {
            radius = new float[]{0, 0, 0, 0};
        }
        GradientDrawable drawable = new GradientDrawable();
        //设置形状为矩形，默认就是矩形
        drawable.setShape(GradientDrawable.RECTANGLE);
        //设置矩形圆角的半径
        drawable.setCornerRadii(radius);
        //设置填充色
        drawable.setColor(corlor);
        return drawable;
    }


    /**
     * 动态创建圆角的Drawable，和在xml中使用<shape>一样的
     *
     * @return
     */
    public static Drawable shapeDrawable(int corlor, float radius) {
        GradientDrawable drawable = new GradientDrawable();
        //设置形状为矩形，默认就是矩形
        drawable.setShape(GradientDrawable.RECTANGLE);
        //设置矩形圆角的半径
        drawable.setCornerRadius(radius);
        //设置填充色
        drawable.setColor(corlor);
        return drawable;
    }

    /**
     * 动态selector
     *
     * @param pressed 图片
     * @param normal
     * @return
     */
    public static Drawable shapeSelector(Drawable pressed, Drawable normal) {
        StateListDrawable drawable = new StateListDrawable();
        //设置按下的图片
        drawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        //设置默认的图片
        drawable.addState(new int[]{}, normal);

        drawable.setEnterFadeDuration(500);
        drawable.setExitFadeDuration(500);


        return drawable;
    }

    /**
     * 动态的创建Selector
     *
     * @param pressed
     * @param normal
     * @return
     */
    public static Drawable shapeSelector(int pressed, int normal, int radius) {
        StateListDrawable drawable = new StateListDrawable();
        //设置按下的图片
        drawable.addState(new int[]{
                android.R.attr.state_checked
        }, shapeDrawable(pressed, radius));
        drawable.addState(new int[]{
                android.R.attr.state_selected
        }, shapeDrawable(pressed, radius));
        drawable.addState(new int[]{
                android.R.attr.state_pressed
        }, shapeDrawable(pressed, radius));
        drawable.addState(new int[]{}, shapeDrawable(normal, radius));

        drawable.setEnterFadeDuration(200);
        drawable.setExitFadeDuration(200);
        return drawable;
    }

    /**
     * 动态的创建Selector  圆角 或者圆形
     *
     * @param pressed
     * @param normal
     * @param isCircle
     * @return
     */
    public static Drawable shapeSelectorStroke(int width, int pressed, int normal,
                                               int pressedStroke, int normalStroke,
                                               int radius, boolean isCircle) {
        StateListDrawable drawable = new StateListDrawable();
        //设置按下的图片
        drawable.addState(new int[]{
                android.R.attr.state_pressed
        }, shapeStrokeDrawable(width, pressed, pressedStroke, radius, isCircle));
        drawable.addState(new int[]{
                android.R.attr.state_checked
        }, shapeStrokeDrawable(width, pressed, pressedStroke, radius, isCircle));
        drawable.addState(new int[]{
                android.R.attr.state_selected
        }, shapeStrokeDrawable(width, pressed, pressedStroke, radius, isCircle));
        drawable.addState(new int[]{}, shapeStrokeDrawable(width, normal, normalStroke, radius, isCircle));

        drawable.setEnterFadeDuration(200);
        drawable.setExitFadeDuration(200);
        return drawable;
    }


    /**
     * 动态创建圆角的Drawable，圆角或者圆形
     *
     * @return
     */
    public static Drawable shapeStrokeDrawable(int width, int solidCorlor, int strokeCorlor, float radius, boolean isCircle) {

        GradientDrawable drawable = new GradientDrawable();
        //设置形状为矩形，默认就是矩形
        drawable.setShape(isCircle ? GradientDrawable.OVAL : GradientDrawable.RECTANGLE);
        if (!isCircle) {
            //设置矩形圆角的半径
            drawable.setCornerRadius(radius);
        }
        //设置填充色
        drawable.setColor(solidCorlor);
        if (strokeCorlor != 0) {
            drawable.setStroke(width == 0 ? 1 : width, strokeCorlor);
        }
        return drawable;
    }

}
