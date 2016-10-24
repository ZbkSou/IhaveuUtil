package com.ihaveu.bc.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.ihaveu.bc.base.BaseApplication;


/**
 * Created by bc on 16/10/11.
 * Describe 尺寸的转换
 */
public class MeasureUtil {
  /**
   * 返回 BaseApplication.getContext()
   * @return
   */
  private static Context getContext(){
    return BaseApplication.getContext();
  }
  /**
   * @param context
   * @return
   */
  public static DisplayMetrics getDisplayMetrics(Context context){
    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
    return displayMetrics;
  }
  public static DisplayMetrics getDisplayMetrics(){
    return getDisplayMetrics(getContext());
  }
  /**
   * 返回屏幕的宽度
   * @param context
   * @return px
   */
  public static int getScreenWidth(Context context){
    int width = getDisplayMetrics(context).widthPixels;
    return width;
  }
  public static int getScreenWidth(){
    return getScreenWidth(getContext());
  }
  /**
   * 返回屏幕的宽度
   * @param context
   * @return px
   */
  public static int getScreenHeight(Context context){
    int height = getDisplayMetrics(context).heightPixels;
    return height;
  }
  public static int getScreenHeight(){
    return getScreenHeight(getContext());
  }
  /**
   * 返回屏幕密度比例
   * @param context
   * @return
   */
  public static float getDensity(Context context){
    float density = getDisplayMetrics(context).density;
    return density;
  }
  public static float getDensity(){
    return getDensity(getContext());
  }
  /**
   * dip转化成px
   * @param context
   * @param dipValue
   * @return
   */
  public static int dip2px(Context context ,float dipValue){
    float scale = getDensity(context);
    return (int) (dipValue * scale + 0.5f);
  }
  public static int dip2px(float dipValue){
    return dip2px(getContext(), dipValue);
  }
  /**
   * px转化成dip
   * @param context
   * @param pxValue
   * @return
   */
  public static int px2dip(Context context,float pxValue){
    float scale = getDensity(context);
    return (int)(pxValue / scale + 0.5f);
  }
  public static int px2dip(float pxValue){
    return px2dip(getContext(), pxValue);
  }
  /**
   * 获取相对于屏幕宽度指定的长度
   * @param f
   * @return
   */
  public static int getSpecifiedDistance(float f){
    return (int) (getScreenWidth()*f);
  }

}
