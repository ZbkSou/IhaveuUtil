package com.ihaveu.bc.model;

import android.content.Context;

import com.ihaveu.bc.callback.JsonCallBack;
import com.ihaveu.bc.network.IModelResponse;
import com.ihaveu.bc.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by bc on 16/10/11.
 * Describe
 */
public class AccountsModel extends Model{
  private Context mContext;
  private String registerUrl = "http://dww.ihaveu.com/accounts.json";
  private String accountsUrl = "http://dww.ihaveu.com/accounts/0.json";
  private String url_check_captcha = "http://dww.ihaveu.com/accounts/validate_captcha.json";
  private String url_get_captcha = "http://dww.ihaveu.com/accounts/captcha_image.json";
  public AccountsModel (Context context){
    mContext = context;
  }
  /**
   * 注册
   * @param params
   * @param modelResponse
   */
  public void register(Map<String,String> params, final IModelResponse<String> modelResponse){
    post(registerUrl,mContext ,params,new JsonCallBack(String.class){

      @Override
      public void onSuccess(Object o, Call call, Response response) {
        try {
          if (new JSONObject((String)o).has("error")) {
            ToastUtil.showToast("信息提交失败,请稍后重试。");
            try {
              modelResponse.onError((new JSONObject((String)o).getString("error")));
            } catch (JSONException e) {
              e.printStackTrace();
            }
          } else {
            modelResponse.onSuccess((String) o,null);
          }
        } catch (JSONException e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * 是否需要验证码
   * @param modelResponse
   */
  public void isNeedCaptcha(final IModelResponse<String> modelResponse){
    get(accountsUrl,mContext ,new JsonCallBack(String.class){
      @Override
      public void onSuccess(Object o, Call call, Response response) {
        modelResponse.onSuccess((String) o,null);
      }
    });
  }

  /**
   * 获取验证码图片
   * @param modelResponse
   */
  public void getCaptchaUrl(final IModelResponse<String> modelResponse) {

    get(url_get_captcha, mContext, new JsonCallBack(String.class) {
      @Override
      public void onSuccess(Object o, Call call, Response response) {
        modelResponse.onSuccess((String) o,null);
      }
    });
  }
  public void validateCaptcha(Map<String, String> request,final IModelResponse<String> modelResponse){
    post(url_check_captcha,mContext,request, new JsonCallBack(String.class) {
      @Override
      public void onSuccess(Object o, Call call, Response response) {
        modelResponse.onSuccess((String) o,null);
      }
    });
  }

}
