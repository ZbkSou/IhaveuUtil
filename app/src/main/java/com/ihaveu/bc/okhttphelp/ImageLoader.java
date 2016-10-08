package com.ihaveu.bc.okhttphelp;

import com.ihaveu.bc.base.BaseAplication;
import com.squareup.picasso.Picasso;

/**
 * Created by bc on 16/9/29.
 * Describe  网络图片请求使用
 * ImageLoader.getInstance()
 * .load(url).placeholder(R.drawable.qraved_bg_default).error(R.drawable.qraved_bg_default).tag(context).into(target, null);
 */
public class ImageLoader {

  private  Picasso picasso ;

  public Picasso getInstance(){
    if(picasso ==null){
      picasso = new Picasso.Builder(BaseAplication.getContext())
          .downloader(new OkHttp3Downloader(BaseAplication.getContext()))
          .build();
    }
    return picasso;
  }

}
