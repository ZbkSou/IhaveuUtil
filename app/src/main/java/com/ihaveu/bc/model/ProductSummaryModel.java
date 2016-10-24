package com.ihaveu.bc.model;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.ihaveu.bc.callback.JsonCallBack;
import com.ihaveu.bc.data.ProductSummary;
import com.ihaveu.bc.network.IModelResponse;

import com.lzy.okhttputils.callback.AbsCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by bc on 16/9/29.
 * Describe model数据提供者 从网络请求数据，数据的缓存模式有效时间都在这个类 中设置
 */
public class ProductSummaryModel extends Model {
    private Context mContext;
    private String Url = "http://touch.ihaveu.com/products.json?response=summary&ids=";
    private String Url_id = "http://touch.ihaveu.com/products.json";

    public ProductSummaryModel(Context context) {
        mContext = context;
    }

    private void fetchProductSummary(String ids, AbsCallback
            absCallback) {
        get(Url + ids, mContext, absCallback);
    }

    public void loadProductSummaryData(String ids, final IModelResponse<ProductSummary>
            modelResponse) {
        fetchProductSummary(ids, new JsonCallBack(new TypeToken<List<ProductSummary>>() {
        }.getType()) {
            @Override
            public void onSuccess(Object o, Call call, Response response) {
                //获取list对象时需要对o进行转型
                modelResponse.onSuccess(null, (ArrayList<ProductSummary>) o);
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                modelResponse.onError(e.getMessage());
                super.onError(call, response, e);
            }
        });
    }

    public void loadIds(int page, int per_page, final IModelResponse<String> modelResponse) {
        Map<String, String> params = new HashMap<>();

        params.put("page", page + "");
        params.put("per_page", per_page + "");
        get(Url_id, mContext, params, new JsonCallBack(String.class) {
            @Override
            public void onSuccess(Object o, Call call, Response response) {
                modelResponse.onSuccess((String) o, null);
            }
        });
    }

}
