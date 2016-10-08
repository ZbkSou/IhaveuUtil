package com.ihaveu.bc.network;

import java.util.ArrayList;

/**
 * 数据返回接口
 * Created by bc on 16/9/29.
 * Describe
 */
public interface IModelResponse<T> {
  public void onSuccess(T model, ArrayList<T> list);
  public void onError(String msg);
}
