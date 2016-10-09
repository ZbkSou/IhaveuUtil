package com.ihaveu.bc.utils;

import android.util.Log;

import com.ihaveu.bc.BuildConfig;

/**
 * Created by zhoubk on 16/10/9.
 * Describe log 工具类 显示   类名：方法名（类名：行号）message
 * eg. D/LoginActivity.java: onSuccess(LoginActivity.java:69){"account":{"id":538783},"code":"bjq7"}
 */
public class LogUtil {

  static String className;//类名
  static String methodName;//方法名
  static int lineNumber;//行数

  private LogUtil() {
        /* Protect from instantiations */
  }

  public static boolean isDebuggable() {
    return BuildConfig.DEBUG;
  }

  private static String createLog(String log) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(methodName);
    buffer.append("(").append(className).append(":").append(lineNumber).append(")");
    buffer.append(log);
    return buffer.toString();
  }

  private static void getMethodNames(StackTraceElement[] sElements) {
    className = sElements[1].getFileName();
    methodName = sElements[1].getMethodName();
    lineNumber = sElements[1].getLineNumber();
  }


  public static void e(String message) {
    if (!isDebuggable())
      return;

    // Throwable instance must be created before any methods
    getMethodNames(new Throwable().getStackTrace());
    Log.e(className, createLog(message));
  }


  public static void i(String message) {
    if (!isDebuggable())
      return;

    getMethodNames(new Throwable().getStackTrace());
    Log.i(className, createLog(message));
  }

  public static void d(String message) {
    if (!isDebuggable())
      return;

    getMethodNames(new Throwable().getStackTrace());
    Log.d(className, createLog(message));
  }

  public static void v(String message) {
    if (!isDebuggable())
      return;

    getMethodNames(new Throwable().getStackTrace());
    Log.v(className, createLog(message));
  }

  public static void w(String message) {
    if (!isDebuggable())
      return;

    getMethodNames(new Throwable().getStackTrace());
    Log.w(className, createLog(message));
  }

  public static void wtf(String message) {
    if (!isDebuggable())
      return;

    getMethodNames(new Throwable().getStackTrace());
    Log.wtf(className, createLog(message));
  }

}

