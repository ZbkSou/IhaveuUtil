package com.ihaveu.bc.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihaveu.bc.R;
import com.ihaveu.bc.interfaces.IMain;
import com.ihaveu.bc.okhttphelp.ImageLoader;
import com.ihaveu.bc.presenter.MainPresenter;
import com.ihaveu.bc.utils.Toast;
import com.lzy.okhttputils.cookie.store.PersistentCookieStore;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity implements IMain {
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
    @BindView(R.id.getuer_button)
    Button getuerButton;
    @BindView(R.id.logout_button)
    Button logoutButton;
    @BindView(R.id.register_button)
    Button registerButton;
    @BindView(R.id.get_goods_list_button)
    Button getGoodsListButton;

    //  private Button getTextView,postTextView;
//  private TextView textView;
<<<<<<< HEAD
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


  @OnClick({R.id.get_request, R.id.login_button, R.id.get_image_request, R.id.clear_image_cache, R.id.getuer_button, R.id.logout_button,R.id.register_button})

  public void onClick(View view) {
    Log.d("MainActivity", "onClick");
    Intent intent;
    switch (view.getId()) {
      case R.id.get_request:
        mainPresenter.get("");
        break;
      case R.id.login_button:
         intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        break;
      case R.id.get_image_request:
        mainPresenter.setImageView(requestImage);
        break;

      case R.id.getuer_button:
        mainPresenter.isLogin();
        break;
      case R.id.logout_button:
        new PersistentCookieStore().removeAllCookie();
        Toast.showToast("注销成功");

        break;
      case R.id.clear_image_cache:
        ImageLoader.clearImageDiskCache();
        break;
      case R.id.register_button:
         intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        break;
=======
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


    @OnClick({R.id.get_request, R.id.login_button, R.id.get_image_request, R.id
            .clear_image_cache, R.id.getuer_button, R.id.logout_button, R.id.register_button,
    R.id.get_goods_list_button})

    public void onClick(View view) {
        Log.d("MainActivity", "onClick");
        Intent intent;
        switch (view.getId()) {
            case R.id.get_request:
                mainPresenter.get("");
                break;
            case R.id.login_button:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.get_image_request:
                mainPresenter.setImageView(requestImage);
                break;

            case R.id.getuer_button:
                mainPresenter.isLogin();
                break;
            case R.id.logout_button:
                new PersistentCookieStore().removeAllCookie();
                MeasureToast.showToast("注销成功");

                break;
            case R.id.clear_image_cache:
                ImageLoader.clearImageDiskCache();
                break;
            case R.id.register_button:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.get_goods_list_button:
                intent = new Intent(this,GoodsListActivity.class);
                startActivity(intent);
                break;
        }
>>>>>>> a173a1a18c05e8040b7aa44fc50b47182d282161
    }

}
