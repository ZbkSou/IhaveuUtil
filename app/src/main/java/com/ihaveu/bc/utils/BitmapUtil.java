package com.ihaveu.bc.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * Created by bc on 16/10/11.
 * Describe 图片工具
 */
public class BitmapUtil {
  /**
   *
   * 旋转图片 用来处理手机拍照后图片自动旋转问题
   * @param angle
   * @param bitmap
   * @return Bitmap
   */
  public static Bitmap rotaingImageView(int angle , Bitmap bitmap) {
    //旋转图片 动作
    Matrix matrix = new Matrix();
    matrix.postRotate(angle);
    System.out.println("angle2=" + angle);
    // 创建新的图片
    Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
        bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    return resizedBitmap;
  }
  /**
   * 获取图片旋转角度
   * @param path
   * @return
   */
  public static int readPictureDegree(String path) {
    int degree  = 0;
    try {
      ExifInterface exifInterface = new ExifInterface(path);
      int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
      switch (orientation) {
        case ExifInterface.ORIENTATION_ROTATE_90:
          degree = 90;
          break;
        case ExifInterface.ORIENTATION_ROTATE_180:
          degree = 180;
          break;
        case ExifInterface.ORIENTATION_ROTATE_270:
          degree = 270;
          break;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return degree;
  }
  /**
   * 直接裁剪bitmap
   * @param bitmap
   * @param reqWidth
   * @param reqHeight
   * @return
   */
  public static Bitmap decodeSampleBitmapFromBitmap(Bitmap bitmap,int reqWidth,int reqHeight){
    try{

      int width = bitmap.getWidth();

      int height = bitmap.getHeight();
      float scaleWidth = (float) reqWidth/width;
      float scaleHeight = (float) reqHeight/height;
      Matrix matrix = new Matrix();
      matrix.postScale(scaleWidth, scaleHeight);
      return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }catch (OutOfMemoryError error){
      return bitmap;
    }

  }

  /**
   * 使用Picasso加载url并裁剪
   * @param url
   * @param reqWidth
   * @param reqHeight
   * @param imageView
   */
  public static void decodeSampleBitmapByPicasso(String url, int reqWidth, int reqHeight, ImageView imageView){
    Picasso.with( imageView.getContext() )
        .load(url)
        .resize(reqWidth,reqHeight)
        .centerCrop()
        .into(imageView);
  }

}
