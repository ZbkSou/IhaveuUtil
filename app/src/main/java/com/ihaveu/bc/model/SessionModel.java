package com.ihaveu.bc.model;

import android.content.Context;
import android.util.Log;

import com.ihaveu.bc.callback.JsonCallBack;
import com.ihaveu.bc.data.Session;
import com.ihaveu.bc.network.IModelResponse;
import com.ihaveu.bc.utils.MeasureToast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by bc on 16/10/8.
 * Describe
 */
public class SessionModel extends Model{
  private Context mContext;
  private String Url = "http://dww.ihaveu.com/sessions.json";

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
  public void isLogin(final IModelResponse<Session> modelResponse){
    get(Url, mContext, new JsonCallBack(Session.class) {
      @Override
      public void onSuccess(Object o, Call call, Response response) {
        modelResponse.onSuccess((Session) o,null);
      }
    });
  }




}
