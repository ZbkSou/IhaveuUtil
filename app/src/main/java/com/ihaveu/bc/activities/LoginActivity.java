package com.ihaveu.bc.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.ihaveu.bc.R;
import com.ihaveu.bc.model.Model;
import com.ihaveu.bc.model.SessionModel;
import com.ihaveu.bc.network.IModelResponse;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONObject;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by bc on 16/10/8.
 * Describe
 */
public class LoginActivity extends Activity {
  @BindView(R.id.username)
  EditText username;
  @BindView(R.id.password)
  EditText password;
  @BindView(R.id.login)
  Button login;
  private SessionModel model;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
    model = new SessionModel(this);
  }

  @OnClick(R.id.login)
  public void onClick() {
    HashMap<String,String> params = new HashMap<>();
    params.put("account[login]",username.getText().toString());
    params.put("account[password]",password.getText().toString());
//    JSONObject jsonObject = new JSONObject(params);
//    model.post("http://www.ihaveu.com/sessions.json", this, params, new StringCallback() {
//      @Override
//      public void onSuccess(String s, Call call, Response response) {
//        Log.d("Login",s);
//      }
//
//      @Override
//      public void onError(Call call, Response response, Exception e) {
//        Log.d("Login",e.getMessage());
//      }
//    });
    model.login(params, new IModelResponse<String>() {
      @Override
      public void onSuccess(String model, ArrayList<String> list) {
        Log.d("Login",model);
      }

      @Override
      public void onError(String msg) {

      }
    });

  }
}
