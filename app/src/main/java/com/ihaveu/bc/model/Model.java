package com.ihaveu.bc.model;

import android.content.Context;
import android.util.Log;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cache.CacheMode;
import com.lzy.okhttputils.callback.AbsCallback;
import com.lzy.okhttputils.callback.FileCallback;

import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by bc on 16/9/29.
 * Describe 用来处理网络请求，作为对okhttp的中转 其他的数据请求在model基础上完成
 *
 */
public class Model {
  public Model(){

  }

  /**
   * Get Method
   * 基础的get请求没有缓存
   * @param url 请求url
   * @param mContext
   * @param absCallback 回调
   */
  public void get(String url, Context mContext, AbsCallback absCallback) {
    OkHttpUtils.get(url)//
        .tag(mContext)//
//        .cacheTime(10000)
        .cacheMode(CacheMode.NO_CACHE)
        .execute(absCallback);
  }

  /**
   * Get Method
   * 带参数的get请求没有缓存
   * @param url
   * @param mContext
   * @param params
   * @param absCallback
   */
  public void get(String url, Context mContext, Map<String, String> params, AbsCallback absCallback){
    StringBuilder newUrl = new StringBuilder();
    newUrl.append(url);
    if (params != null) {
      if (url.indexOf("?") < 0) {
        newUrl.append("?");
      }
      for (String key : params.keySet()) {
        newUrl.append(key);
        newUrl.append("=");
        newUrl.append(params.get(key));
        newUrl.append("&");
      }
      newUrl.deleteCharAt(newUrl.length() - 1);
    }
    get(newUrl.toString(),mContext,absCallback);
  }

  /**
   * Get Method
   * 可以设置缓存get请求
   * @param url
   * @param mContext
   * @param time 缓存保留时间 -1 永久
   * @param cacheMode 缓存模式
   * @param absCallback
   */
  public void get(String url, Context mContext,int time,CacheMode cacheMode, AbsCallback absCallback) {
    OkHttpUtils.get(url)//
        .tag(mContext)//
        .cacheTime(time)
        .cacheMode(cacheMode)
        .execute(absCallback);
  }

  /**
   * Post Method
   * 发送json
   * {"account[login]":"13102272166","account[password]":"123456"}
   * @param url
   * @param mContext
   * @param jsonObject
   * @param absCallback
   */
  public void post(String url,Context mContext,JSONObject jsonObject, AbsCallback absCallback){
//    JSONObject jsonObject = new JSONObject(params);
    OkHttpUtils.post(url)//
        .tag(mContext)//
        .upJson(jsonObject.toString())//
        .execute(absCallback);
  }
  /**
   * Post Method
   * 发送String
   * @param url
   * @param mContext
   * @param string
   * @param absCallback
   */
  public void post(String url,Context mContext,String string, AbsCallback absCallback){
//    JSONObject jsonObject = new JSONObject(params);
    OkHttpUtils.post(url)//
        .tag(mContext)//
        .upString(string)//
        .execute(absCallback);
  }
  /**
   * Post Method
   * 发送map
   * @param url
   * @param mContext
   * @param params 要发送的map
   * @param absCallback
   */
  public void post(String url,Context mContext,Map<String,String> params , AbsCallback absCallback){
    OkHttpUtils.post(url)//
        .tag(mContext)//
        .params(params)
        .execute(absCallback);
  }

  /**
   * Post Method
   * @param url
   * @param mContext
   * @param params
   * @param absCallback
   */
  public void put(String url,Context mContext,Map<String, String> params, AbsCallback absCallback){
    OkHttpUtils.put(url)//
         .tag(mContext)//
        .params(params)//
        .execute(absCallback);
  }

  /**
   * 普通的下载文件，不支持多线，断点
   * @param url
   * @param mContext
   * @param fileName
   * @param fileCallback
   */
  public void fileDowload(String url,Context mContext,String fileName, FileCallback fileCallback){
    OkHttpUtils.get(url)
        .tag(mContext)
        .execute(fileCallback);
  }
  public void upFile(){

  }

}
