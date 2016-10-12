package com.ihaveu.bc.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ihaveu.bc.R;
import com.ihaveu.bc.base.BaseAplication;

/**
 * Created by bc on 16/10/9.
 * Describe
 */
public class Toast {
    /**
     * 普通样式 圆角矩形
     * @param text
     */
    public static void showToast(String text){
      View v = LayoutInflater.from(BaseAplication.getContext()).inflate(R.layout.ihaveu_toast_layout, null);
      TextView textView = (TextView) v.findViewById(R.id.toast_text);
      textView.setText(text);
      android.widget.Toast toast = new android.widget.Toast(BaseAplication.getContext());
      toast.setDuration(android.widget.Toast.LENGTH_SHORT);
      toast.setView(v);
      toast.show();
    }
  /**
   * 原生Toast
   *
   * @param context
   * @param text
   */
  public static void toast(Context context, String text) {
    try {
      android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT).show();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  }

