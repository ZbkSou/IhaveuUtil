package com.ihaveu.bc.model;

import android.content.Context;
import android.util.Log;

import com.ihaveu.bc.callback.JsonCallBack;
import com.ihaveu.bc.network.IModelResponse;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by bc on 16/10/8.
 * Describe
 */
public class SessionModel extends Model{
  private Context mContext;
  private String Url = "http://www.ihaveu.com/sessions.json";
  public SessionModel (Context context){
    mContext = context;
  }
  public void login(Map<String,String> params, final IModelResponse<String> modelResponse){
    post(Url, mContext, params, new JsonCallBack(String.class) {

      @Override
      public void onSuccess(Object o, Call call, Response response) {
        modelResponse.onSuccess((String) o,null);
      }

      @Override
      public void onError(Call call, Response response, Exception e) {
        Log.d("Login",e.getMessage());
      }
    });
  }

}
