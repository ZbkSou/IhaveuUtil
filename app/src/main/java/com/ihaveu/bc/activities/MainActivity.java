package com.ihaveu.bc.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihaveu.bc.R;
import com.ihaveu.bc.interfaces.IMain;
import com.ihaveu.bc.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity implements IMain{
  @BindView(R.id.request_text)
  TextView requestText;
  @BindView(R.id.get_request)
  Button getRequest;
  @BindView(R.id.login_button)
  Button loginButton;
  @BindView(R.id.request_image)
  ImageView requestImage;
  @BindView(R.id.get_image_request)
  Button getImageRequest;
  @BindView(R.id.clear_image_cache)
  Button clearImageCache;
  //  private Button getTextView,postTextView;
//  private TextView textView;
  private MainPresenter mainPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    mainPresenter = new MainPresenter(this, this);

  }


  @Override
  public void setTextView(final String text) {

        requestText.setText(text);
  }

//  @Override
//  public void setImageView(Bitmap bitmap) {
//    requestImage.setImageBitmap(bitmap);
//  }

  @OnClick({R.id.get_request, R.id.login_button, R.id.get_image_request,R.id.clear_image_cache})
  public void onClick(View view) {
    Log.d("MainActivity", "onClick");
    switch (view.getId()) {
      case R.id.get_request:
        mainPresenter.get("");
        break;
      case R.id.login_button:
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        break;
      case R.id.get_image_request:
//        mainPresenter.getImage("http://img.dahe.cn/qf/2016/9/27/1159WOG37B.jpg", requestImage);
      case R.id.clear_image_cache:

    }
  }
}
