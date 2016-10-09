package com.ihaveu.bc.presenter;

/**
 * Created by bc on 16/9/29.
 * Describe
 */

import android.content.Context;
import android.widget.ImageView;

import com.ihaveu.bc.data.ProductSummary;
import com.ihaveu.bc.interfaces.IMain;
import com.ihaveu.bc.model.ProductSummaryModel;
import com.ihaveu.bc.network.IModelResponse;
import com.ihaveu.bc.okhttphelp.ImageLoader;

import java.util.ArrayList;

/**
 * Created by bc on 16/9/22.
 * Describe
 */
public class MainPresenter {
  private Context mContext;
  private static String TAG = "MainPresenter";
  private IMain iMian;
  private ProductSummaryModel productSummaryModel;

  public MainPresenter(Context context, IMain iMian) {
    mContext = context;
    this.iMian = iMian;
    productSummaryModel = new ProductSummaryModel(mContext);
  }
  public void get(final String url) {
    productSummaryModel.loadProductSummaryData("34169112%2C34170107%2C35895108%2C35957107%2C35962101%2C36018109%2C36029142%2C36107108%2C38428107%2C38442107%2C3983172%2C3970967%2C3972472%2C3968072%2C3973072%2C3973967%2C3974072%2C3974567%2C3974754%2C3974867%2C",
        new IModelResponse<ProductSummary>() {
          @Override
          public void onSuccess(ProductSummary model, ArrayList<ProductSummary> list) {
            iMian.setTextView(list.size()+"");
          }

          @Override
          public void onError(String msg) {

          }
        });
  }

    public void setImageView(ImageView imageView){
        ImageLoader.display("http://img.dahe.cn/qf/2016/9/27/1159WOG37B.jpg",imageView);
    }


}
