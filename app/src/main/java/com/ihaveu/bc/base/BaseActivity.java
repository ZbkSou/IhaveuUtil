package com.ihaveu.bc.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ihaveu.bc.R;
import com.lzy.okhttputils.OkHttpUtils;

import butterknife.ButterKnife;

/**
 * todo 添加初始化toolbar
 * Created by bc on 16/10/11.
 * Describe
 */
public abstract class BaseActivity extends AppCompatActivity{
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    添加ButterKinife 不需要再子类绑定
    ButterKnife.bind(this);
  }
  protected void onResume() {
    super.onResume();
//        MobclickAgent.onResume(this);
  }

  protected void onPause() {
    super.onPause();

//        MobclickAgent.onPause(this);
  }

  /**
   * 获取子类名
   * @return
   */
  protected String getName(){
    return getClass().getSimpleName();
  }



  /**
   * 耗时操作
   */
  public void showHandleLoading() {
    View view = findViewById(R.id.loading_handle);
    view.setOnClickListener(null);
    view.setVisibility(View.VISIBLE);
  }

  public void hideHandleLoading() {
    View view = findViewById(R.id.loading_handle);
    view.setOnClickListener(null);
    view.setVisibility(View.GONE);
  }
}
