package com.ihaveu.bc.okhttphelp;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.ihaveu.bc.base.BaseAplication;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

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
            picasso = new Picasso.Builder(BaseAplication.getContext())
                    .downloader(new OkHttp3Downloader(BaseAplication.getContext()))
                    .build();
        }
        return picasso;
    }

    public static Picasso display(String url, ImageView imageView) {
        picasso.load(url)
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageView);
        return picasso;
    }


    public static boolean clearImageDiskCache() {
        File cache = new File(BaseAplication.getContext().getCacheDir(), "picasso-cache");
        if (cache.exists() && cache.isDirectory()) {
            return deleteDir(cache);
        }
        return false;
    }
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // The directory is now empty so delete it
        return dir.delete();
    }

}
