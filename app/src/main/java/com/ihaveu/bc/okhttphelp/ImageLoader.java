package com.ihaveu.bc.okhttphelp;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.ihaveu.bc.base.BaseApplication;
import com.ihaveu.bc.utils.FileUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.BitmapCallback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by bc on 16/9/29.
 * Describe  网络图片请求使用
 * ImageLoader.getInstance()
 * .load(url).placeholder(R.drawable.qraved_bg_default).error(R.drawable.qraved_bg_default).tag
 * (context).into(target, null);
 */
public class ImageLoader {

  private static Picasso picasso = getInstance();

  private static Picasso getInstance() {
    if (picasso == null) {
      picasso = new Picasso.Builder(BaseApplication.getContext())
          .downloader(new OkHttp3Downloader(BaseApplication.getContext()))
          .build();
    }
    return picasso;
  }

  /**
   * 普通图片加载
   *
   * @param url
   * @param imageView
   * @return
   */
  public static Picasso display(String url, ImageView imageView) {
    picasso.load(url)
        .memoryPolicy(MemoryPolicy.NO_STORE, MemoryPolicy.NO_CACHE)
        .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
        .into(imageView);
    return picasso;
  }

  /**
   * 本地图片加载
   *
   * @param file
   * @param imageView
   * @return
   */
  public static Picasso display(File file, ImageView imageView) {
    picasso.load(file)
        .memoryPolicy(MemoryPolicy.NO_STORE, MemoryPolicy.NO_CACHE)
        .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
        .into(imageView);
    return picasso;
  }

  /**
   * 清楚图片缓存
   *
   * @return
   */
  public static boolean clearImageDiskCache() {
    File cache = new File(BaseApplication.getContext().getCacheDir(), "picasso-cache");
    if (cache.exists() && cache.isDirectory()) {
      return FileUtil.deleteDir(cache);
    }
    return false;
  }


  /**
   * 用于验证码图片的请求可以携带cookies
   * @param url
   * @param imageView
   */
  public static void displayCookiesImage(String url,final ImageView imageView) {
    OkHttpUtils.get(url)//
        .execute(new BitmapCallback() {
          @Override
          public void onSuccess(Bitmap bitmap, Call call, Response response) {
            imageView.setImageBitmap(bitmap);
          }
        });
  }
  /**
   * 用于获取图片具体操作在回调接口中定义
   * @param url
   * @param bitmapCallback
   */
  public static void getImage(String url,BitmapCallback bitmapCallback) {
    OkHttpUtils.get(url)//
        .execute(bitmapCallback);
  }

}
