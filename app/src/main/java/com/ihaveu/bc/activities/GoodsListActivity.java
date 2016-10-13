package com.ihaveu.bc.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;

import com.ihaveu.bc.R;
import com.ihaveu.bc.adapter.ProductSummaryAdapter;
import com.ihaveu.bc.data.ProductSummary;
import com.ihaveu.bc.interfaces.IGoodsList;
import com.ihaveu.bc.presenter.GoodsListPresenter;
import com.ihaveu.bc.widget.LoadMoreRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsListActivity extends Activity implements SwipeRefreshLayout
        .OnRefreshListener, LoadMoreRecyclerView.LoadMoreListener,IGoodsList {

    private GridLayoutManager mGridLayoutManager;
    private ArrayList<ProductSummary> productSummaries;
    private GoodsListPresenter goodsListPresenter;
    private ProductSummaryAdapter adapter;
    private int currentPage = 1;
    private int per_page = 2 ;

    @BindView(R.id.load_more_recycler_view)
    LoadMoreRecyclerView mLoadMoreRecyclerView;
    @BindView(R.id.swipe_refreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        ButterKnife.bind(this);
        mGridLayoutManager = new GridLayoutManager(this,2);
        mLoadMoreRecyclerView.setLayoutManager(mGridLayoutManager);
        goodsListPresenter = new GoodsListPresenter(this,this);
        goodsListPresenter.getIds(currentPage,per_page);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mLoadMoreRecyclerView.setLoadMoreListener(this);
    }

    @Override
    public void onRefresh() {
        currentPage = 1;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goodsListPresenter.getIds(currentPage,per_page);
                mSwipeRefreshLayout.setRefreshing(false);
                mLoadMoreRecyclerView.notifyMoreFinish(true);//代替notifyDataChanged
            }
        },1000);
    }

    @Override
    public void onLoadMore() {
        currentPage ++ ;
        mSwipeRefreshLayout.setRefreshing(false);
        goodsListPresenter.getIds(currentPage,per_page);
    }

    @Override
    public boolean hasLoadMore() {
        return false;
    }

    @Override
    public void loadProductSummaries(ArrayList<ProductSummary> productSummaries) {
        if(this.productSummaries == null){
            this.productSummaries = productSummaries;
            adapter = new ProductSummaryAdapter(this,productSummaries);
            mLoadMoreRecyclerView.setAdapter(adapter);
        }else{
            if(currentPage == 1) {
                this.productSummaries.clear();
                this.productSummaries.addAll(productSummaries);
            }else{
                this.productSummaries.addAll(productSummaries);
            }
        }
        if(productSummaries.size() < per_page){
            mLoadMoreRecyclerView.notifyMoreFinish(false);
        }else{
            mLoadMoreRecyclerView.notifyMoreFinish(true);
        }
    }

    @Override
    public void loadIds(String ids) {
        goodsListPresenter.getProductSummaries(ids);
    }

}
