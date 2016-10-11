package com.ihaveu.bc.utils;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by bc on 16/10/11.
 * Describe 尺寸的转换
 */
public class DensityHelper {
  public static Context context;

  public static void init(Context cxt){
    context = cxt;
  }

  /**
   * 获取屏幕 像素密度比
   * @return
   */
  public static float getDensity(){
    return context.getResources().getDisplayMetrics().density;
  }

  /**
   * Device
   * dp -> px
   */
  public static int dip2px(float dip){
    return (int)(dip * getDensity() + 0.5f);
  }
  /**
   * px -> dp
   * @param px
   * @return
   */
  public static int px2dip(float px){
    return (int) (px / getDensity() + 0.5f);
  }

  /**
   * 获取屏幕Display
   * 用于 获取屏幕宽高
   * @return
   */
  public static Display getDisplay(){
    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    Display display = wm.getDefaultDisplay();
    return display;
  }


}
