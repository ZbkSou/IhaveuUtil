package com.ihaveu.bc.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.ihaveu.bc.R;
import com.ihaveu.bc.model.AccountsModel;
import com.ihaveu.bc.model.SessionModel;
import com.ihaveu.bc.network.IModelResponse;
import com.ihaveu.bc.okhttphelp.ImageLoader;
import com.ihaveu.bc.utils.TextUtil;
import com.ihaveu.bc.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bc on 16/10/10.
 * Describe
 */
public class RegisterActivity extends Activity {
  @BindView(R.id.username)
  EditText username;
  @BindView(R.id.password)
  EditText password;
  @BindView(R.id.register_button)
  Button registerButton;
  @BindView(R.id.captcha_edit)
  EditText captchaEdit;
  @BindView(R.id.captcha)
  ImageView captcha;
  private SessionModel sessionModel;
  private AccountsModel accountsModel;
  /**
   * 验证码图片是否已经展示
   */
  private boolean isHasShowCaptcha = false;
  private Context mContext;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    ButterKnife.bind(this);
    sessionModel = new SessionModel(this);
    accountsModel = new AccountsModel(this);
    mContext = this;
  }

  @OnClick(R.id.register_button)
  public void onClick() {
    final HashMap<String, String> params = new HashMap<>();
    params.put("account[phone]", username.getText().toString());
    params.put("account[password]", password.getText().toString());
    params.put("account[password_confirmation]", password.getText().toString());
    if (TextUtil.isValidText(captchaEdit.getText().toString())) {
      params.put("captcha", captchaEdit.getText().toString());
    }
    params.put("account[client]", "android");
    //判断是否需要验证码
    accountsModel.isNeedCaptcha(new IModelResponse<String>() {
                                  @Override
                                  public void onSuccess(String model, ArrayList<String> list) {
                                    try {

                                        if (new JSONObject(model).getString("need_captcha").equals("true") && !isHasShowCaptcha) {
//获取验证码
                                          accountsModel.getCaptchaUrl(new IModelResponse<String>() {
                                            @Override
                                            public void onSuccess(String model, ArrayList<String> list) {
                                              try {
                                                isHasShowCaptcha = true;
                                                ImageLoader.displayCookiesImage(new JSONObject(model).getString("url"), captcha);
                                              } catch (JSONException e) {
                                                e.printStackTrace();
                                              }
                                            }

                                            @Override
                                            public void onError(String msg) {

                                            }
                                          });
                                        }

                                  else {
                                        if (isHasShowCaptcha && !TextUtil.isValidText(captchaEdit.getText().toString())) {
                                          ToastUtil.showToast( "请输入验证码");
                                        } else if (TextUtil.isValidText(captchaEdit.getText().toString())) {
                                          Map<String, String> map = new HashMap<String, String>();
                                          map.put("captcha", captchaEdit.getText().toString());
                                          accountsModel.validateCaptcha(map, new IModelResponse<String>() {

                                            @Override
                                            public void onSuccess(String model, ArrayList<String> list) {
                                              try {
                                                if (new JSONObject(model).getString("is_valid").equals("true")) {
                                                  register(params);
                                                } else {
                                                  ToastUtil.showToast( "请重新输入验证码（验证码输入错误）");
                                                }
                                              } catch (JSONException e) {
                                                e.printStackTrace();
                                              }
                                            }

                                            @Override
                                            public void onError(String msg) {

                                            }
                                          });
                                        } else {
                                          register(params);
                                        }

                                      }
                                    } catch (JSONException e) {
                                      e.printStackTrace();
                                    }
                                  }

                                  @Override
                                  public void onError(String msg) {

                                  }
                                }

    );


  }

  private void register(Map<String, String> map) {
    accountsModel.register(map, new IModelResponse<String>() {

      @Override
      public void onSuccess(String model, ArrayList<String> list) {
        try {
          ToastUtil.showToast(new JSONObject(model).getJSONObject("account").getInt("id")+"");
        } catch (JSONException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onError(String msg) {
        ToastUtil.showToast(msg);
      }
    });
  }

}
