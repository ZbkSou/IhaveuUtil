package com.ihaveu.bc.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bc on 16/10/10.
 * Describe 对文本字体的操作，
 */
public class TextUtil {
  public final static String TAG = "TextUtil";
  //注意 ： 英文字体包括数字
  //字体包存放路径
  public final static String FONT_CHINESE_PATH = "fangzhenglantingxihei_GBK.TTF";
  public final static String FONT_EN_3 = "San Francisco Display Medium.otf";
  public final static String FONT_EN_2 = "San Francisco Display Regular.otf";
  public final static String FONT_EN_1 = "San Francisco Display Thin.otf";
  public final static String FONT_SECKILL_NUM = "DS-DIGI.TTF";
  public final static int TYPE_FONT_CHINESE = 0;
  public final static int TYPE_FONT_EN_1 = 1;
  public final static int TYPE_FONT_EN_2 = 2;
  public final static int TYPE_FONT_EN_3 = 3;
  public final static int TYPE_FONT_SECKILL_NUM = 4;

  private static Map<String, Typeface> mTypefaces;
  /**
   * 初始化字体
   *
   * @param context
   */
  public static void initTypeface(Context context) {
    if (mTypefaces == null) {
      mTypefaces = new HashMap<>();
      mTypefaces.put(FONT_CHINESE_PATH, Typeface.createFromAsset(context.getAssets(), FONT_CHINESE_PATH));
      mTypefaces.put(FONT_EN_1, Typeface.createFromAsset(context.getAssets(), FONT_EN_1));
      mTypefaces.put(FONT_EN_2, Typeface.createFromAsset(context.getAssets(), FONT_EN_2));
      mTypefaces.put(FONT_EN_3, Typeface.createFromAsset(context.getAssets(), FONT_EN_3));
      mTypefaces.put(FONT_SECKILL_NUM,Typeface.createFromAsset(context.getAssets(),FONT_SECKILL_NUM));
    }
  }
  /**
   * 获取字体集合
   * @return
   */
  public static Map<String, Typeface> getTypeFaceMap(){
    return mTypefaces;
  }
  /**
   * 设置textView的字体<br/>
   * 0 中文  1 英文  2 英文斜体 3 英文粗斜体 4英文粗体 其中英文包括中文
   * 具体根据需求添加字体包
   * @param textView
   * @param type
   */
  public static void setFont(TextView textView, int type) {
    if (textView == null) {
      return;
    }
    switch (type) {
      case TYPE_FONT_CHINESE:
        //中文
        textView.setTypeface(mTypefaces.get(FONT_CHINESE_PATH));
        break;
      case TYPE_FONT_EN_1:
        //英文 1号
        textView.setTypeface(mTypefaces.get(FONT_EN_1));
        break;
      case TYPE_FONT_EN_2:
        //英文 2号
        textView.setTypeface(mTypefaces.get(FONT_EN_2));
        break;
      case TYPE_FONT_EN_3:
        //英文 3号
        textView.setTypeface(mTypefaces.get(FONT_EN_3));
        break;
      case TYPE_FONT_SECKILL_NUM:
        textView.setTypeface(mTypefaces.get(FONT_SECKILL_NUM));
        break;
      default:
        //中文
        textView.setTypeface(mTypefaces.get(FONT_CHINESE_PATH));
        break;
    }
  }
  /**
   * 判断一个字符串是否有效
   *
   * @param text
   * @return
   */
  public static boolean isValidText(String text) {
    if (text == null || text.trim().equals("null") || text.trim().isEmpty()) {
      return false;
    }
    return true;
  }
  /**
   * 验证是否是合格的手机号
   *
   * @param s
   * @return
   */
  public static boolean idMobile(String s) {
    Pattern pattern_phone = Pattern.compile("^[1]+\\d{10}"); //手机格式匹配
    Matcher matcher_phone = pattern_phone.matcher(s);
    return matcher_phone.matches();
  }

  /**
   * 验证是否是合格的邮箱
   *
   * @param s
   * @return
   */
  public static boolean idEmail(String s) {
    Pattern pattern_email = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");//邮箱格式匹配
    Matcher matcher = pattern_email.matcher(s);
    return matcher.matches();
  }
  /**
   * 验证是否是数字
   * @param s
   * @return
   */
  public static boolean isNuM(String s){
    Pattern pattern_num = Pattern.compile("^[+-]?[0-9]+$");
    Matcher matcher = pattern_num.matcher(s);
    return matcher.matches();
  }
  /**
   * 遍历View将其中TextView设置字体
   * 用于对三方控件的字体转换
   * @param context
   * @param root
   * @param type    0 中文  1 英文  2 英文斜体 3 英文粗斜体 4英文粗体 其中英文包括中文
   */
  public static void setFont(final Context context, final View root, final int type, String extra) {
    try {
      LogUtil.i( "try");
      if (root instanceof ViewGroup) {
        LogUtil.i( "ViewGroup");
        ViewGroup viewGroup = (ViewGroup) root;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
          setFont(context, viewGroup.getChildAt(i), type, extra);
        }
      } else if (root instanceof TextView) {
        LogUtil.i( "TextView");
        setFont((TextView) root, type);
      } else {
        LogUtil.i( "else");
      }
    } catch (Exception e) {
      LogUtil.i("viewGroup Exception");
      e.printStackTrace();
    }
  }

  /**
   * 遍历View将其中TextView设置成 方正兰亭细黑字体
   *
   * @param context
   * @param root
   */
  public static void setFont(final Context context, final View root) {
    setFont(context, root, 0, "");
  }


  /**
   * 小数转百分数
   * @param i
   * @return
   */
  public static  String getPercent(double i){
    DecimalFormat df = new DecimalFormat("0%");
    String r = df.format(i);
    return "立减"+r;
  }
  /**
   * 获取想要颜色的字的字符串
   * @param color #ffffff
   * @param text string
   * @return
   */
  public static String getNeedColorString(String color,String text){
    String start = "<font color=\"";
    String center = "\">";
    String end = "</font>";
    return start + color + center + text + end;
  }

  /**
   * 获得人民币标志
   * @param price
   * @return
   */
  public static String rmb(String price) {
    return "¥" + price;
  }
}
