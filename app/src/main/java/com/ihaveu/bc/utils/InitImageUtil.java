package com.ihaveu.bc.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.ihaveu.bc.R;
import com.ihaveu.bc.okhttphelp.ImageLoader;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.BitmapCallback;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by bc on 16/10/21.
 * Describe
 */
public class InitImageUtil {
  private static final String IMAGEINIT = "InitImage";//图片缓存文件名

  public static Bitmap getInitImage(Context context) {
    File cache = new File(context.getApplicationContext().getCacheDir(), IMAGEINIT);
    if (!cache.exists()) {
      //noinspection ResultOfMethodCallIgnored
      cache.mkdirs();
      return BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
    }
    if (cache.exists() && cache.isDirectory()) {
      if (cache.list().length > 0) {
        String[] children = cache.list();
        LogUtil.d(cache.getName() + children[0]);
        return BitmapFactory.decodeFile(cache.getPath()+"/"+children[0]);
      }
    } else {
      return BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
    }
    return BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
  }

  public static void saveInitImage(final String url, final Context context) {
    final File cache = new File(context.getApplicationContext().getCacheDir(), IMAGEINIT);
   //文件夹存在并有文件判断是否为最新的
    if (cache.exists()&&cache.list().length > 0) {
      String[] children = cache.list();
      LogUtil.d(children[0]);
      if (children[0].equals(MD5Util.encrypt(url) + ".jpg")) {//是最新的不做处理

        return;
      }else {//不是最新的删除文件夹
        FileUtil.deleteDir(cache);
          cache.mkdirs();
      }
    }

    ImageLoader.getImage(url, new BitmapCallback() {
      @Override
      public void onSuccess(Bitmap bitmap, Call call, Response response) {
        File file = new File(cache, MD5Util.encrypt(url) + ".jpg");
        FileOutputStream out = null;
        try {
          out = new FileOutputStream(file);
          bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        try {
          out.flush();
          out.close();
        } catch (IOException e) {

        }
      }


    });
  }

}
