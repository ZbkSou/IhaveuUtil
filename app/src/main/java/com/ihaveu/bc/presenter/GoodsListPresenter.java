package com.ihaveu.bc.presenter;


import android.content.Context;

import com.ihaveu.bc.data.ProductSummary;
import com.ihaveu.bc.interfaces.IGoodsList;
import com.ihaveu.bc.model.ProductSummaryModel;
import com.ihaveu.bc.network.IModelResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GoodsListPresenter {
    private IGoodsList iGoodsList;
    private ProductSummaryModel productSummaryModel;
    private Context mContext;

    public GoodsListPresenter(Context context, IGoodsList iGoodsList) {
        this.iGoodsList = iGoodsList;
        this.mContext = context;
        productSummaryModel = new ProductSummaryModel(mContext);
    }


    public void getProductSummaries(String ids) {
        productSummaryModel.loadProductSummaryData
                (ids, new IModelResponse<ProductSummary>() {
                    @Override
                    public void onSuccess(ProductSummary model, ArrayList<ProductSummary>
                            list) {
                        iGoodsList.loadProductSummaries(list);
                    }

                    @Override
                    public void onError(String msg) {

                    }
                });
    }

    public void getIds(int page, int per_page) {
        productSummaryModel.loadIds(page, per_page, new IModelResponse<String>() {
            @Override
            public void onSuccess(String model, ArrayList<String> list) {
                try {
                    String ids = "";
                    JSONObject response = new JSONObject(model);
                    if (response.has("data")) {
                        JSONArray responseArray = response.getJSONArray("data");
                        if (responseArray.length() != 0) {
                            for (int i = 0; i < responseArray.length(); i++) {
                                try {
                                    JSONObject object = responseArray.getJSONObject(i);
                                    String id = object.getString("id");
                                    ids += id + ",";
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            iGoodsList.loadIds(ids);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
