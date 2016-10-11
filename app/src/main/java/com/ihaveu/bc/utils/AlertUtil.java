package com.ihaveu.bc.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by bc on 16/10/11.
 * Describe 提供提示框
 */
public class AlertUtil {
  /**
   * 提示框 普通提示框 确定
   *
   * @param context
   * @param msg             提示内容
   * @param onClickListener
   */
  public static void alert(Context context, String msg, DialogInterface.OnClickListener onClickListener) {
    alert(context, null, msg, onClickListener);
  }
  /**
   * alert
   * 带标题提示框
   * @param context
   * @param title
   * @param msg
   * @param poClickListener
   */
  public static void alert(Context context, String title, String msg, DialogInterface.OnClickListener poClickListener) {
    alert(context, title, msg, poClickListener, null);
  }
  /**
   * 提示框 确定
   *
   * @param context
   * @param title           标题
   * @param msg             提示内容
   * @param poClickListener 确定
   * @param neClickListener 取消
   */
  public static void alert(Context context, String title, String msg, DialogInterface.OnClickListener poClickListener,
                           DialogInterface.OnClickListener neClickListener) {
    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    builder.setMessage(msg);
    builder.setCancelable(false);
    if (title != null) {
      builder.setTitle(title);
    } else {
      builder.setTitle("提示");
    }
    // 绑定
    // 确定按钮事件
    if (poClickListener != null) {
      builder.setPositiveButton("确定", poClickListener);
      // 默认关闭弹出框
    } else {
      builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
          // TODO Auto-generated method stub
          dialog.dismiss();
        }
      });
    }
    // 取消 按钮事件
    if (neClickListener != null) {
      builder.setNegativeButton("取消", neClickListener);
    }
    AlertDialog dialog = builder.create();
    dialog.setCanceledOnTouchOutside(false);
    dialog.show();
  }

}
