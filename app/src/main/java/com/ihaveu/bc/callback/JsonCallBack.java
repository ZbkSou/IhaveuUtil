package com.ihaveu.bc.callback;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.lzy.okhttputils.callback.AbsCallback;
import com.lzy.okhttputils.request.BaseRequest;

import java.lang.reflect.Type;

import okhttp3.Response;

/**
 * Created by bc on 16/9/29.
 * Describe 获取javabean的回调 new JsonCallBack<T>()
 */
public abstract class JsonCallBack<T> extends AbsCallback<T> {
  private Class<T> clazz;
  private Type type;

  /**
   * 传class,直接返回解析生成的对象
   */
  public JsonCallBack(Class<T> clazz) {
    this.clazz = clazz;
  }

  /**
   * 对于需要返回集合类型的,可以传type
   * type = new TypeToken<List<你的数据类型>>(){}.getType()
   */
  public JsonCallBack(Type type) {
    this.type = type;
  }

  @Override
  public void onBefore(BaseRequest request) {
    super.onBefore(request);
  }

  @Override
  public T parseNetworkResponse(Response response) throws Exception {
    String responseData = response.body().string();
    if(TextUtils.isEmpty(responseData))return null;

    if (clazz == String.class) return (T) responseData;
    if (clazz != null) return new Gson().fromJson(responseData, clazz);
    if (type != null) return new Gson().fromJson(responseData, type);
    return null;
  }
}
