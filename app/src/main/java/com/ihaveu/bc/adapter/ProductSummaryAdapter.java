package com.ihaveu.bc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihaveu.bc.R;
import com.ihaveu.bc.data.ProductSummary;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductSummaryAdapter extends RecyclerView.Adapter{
    private Context mContext;
    private ArrayList<ProductSummary> productSummaries;
    private LayoutInflater layoutInflater;

    public ProductSummaryAdapter(Context context, ArrayList<ProductSummary> productSummaries){
        if(productSummaries == null){
            productSummaries = new ArrayList<>();
        }
        this.productSummaries = productSummaries;
        this.mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.itemgrid_goodslist,parent,false);
        return new ProductSummaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, int position) {
        ProductSummaryViewHolder holder = (ProductSummaryViewHolder) h;
        ProductSummary productSummary = productSummaries.get(position);
        holder.tvName.setText(productSummary.getName());
    }

    @Override
    public int getItemCount() {
        return productSummaries.size();
    }

     class ProductSummaryViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.img_productSummary) ImageView imageView;
        @BindView(R.id.tv_productSummary_name) TextView tvName;
        public ProductSummaryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
