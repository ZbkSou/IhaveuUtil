package com.ihaveu.bc.interfaces;

import com.ihaveu.bc.data.ProductSummary;

import java.util.ArrayList;

public interface IGoodsList {
    void loadProductSummaries(ArrayList<ProductSummary> productSummaries);
    void loadIds(String ids);
}
