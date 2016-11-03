package com.ihaveu.bc.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.ihaveu.bc.R;
import com.ihaveu.bc.fragment.ColorFragment;
import com.ihaveu.bc.utils.MeasureUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewWidgetActivity extends FragmentActivity implements AppBarLayout.OnOffsetChangedListener,TabLayout.OnTabSelectedListener {

  @BindView(R.id.tabLayout)
  TabLayout tabLayout;
  @BindView(R.id.appbar_layout)
  AppBarLayout appbarLayout;
  @BindView(R.id.viewpager)
  ViewPager viewpager;
  @BindView(R.id.tipImage)
  ImageView tipImage;
  private Fragment mFragmentCategoryExtra = new ColorFragment();
  private String[] mTitles = new String[]{"品牌","男士","女士","家居","东方奢侈品"};

  private int[] mBgId = new int[]{R.color.red,R.color.gray,R.color.red,R.color.gray,
      R.color.red};
  private int[] mTipId = new int[]{R.color.gray,R.color.red,R.color.gray,
      R.color.red,R.color.gray};
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_widget);
    ButterKnife.bind(this);
    viewpager.setAdapter(new FragmentListAdapter(getSupportFragmentManager()));
    tabLayout.setupWithViewPager(viewpager);
    //必须在setupwithViewPager之后设置
    tabLayout.setOnTabSelectedListener(this);
    appbarLayout.addOnOffsetChangedListener(this);
  }

  @Override
  public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
    float alpha = Math.abs(verticalOffset + MeasureUtil.dip2px(100)) * 1f / MeasureUtil.dip2px(100);
    tipImage.setAlpha(alpha);
  }

  @Override
  public void onTabSelected(TabLayout.Tab tab) {
    viewpager.setCurrentItem(tab.getPosition());
    appbarLayout.setBackgroundResource(mBgId[tab.getPosition()]);
    tipImage.setImageResource(mTipId[tab.getPosition()]);
  }

  @Override
  public void onTabUnselected(TabLayout.Tab tab) {

  }

  @Override
  public void onTabReselected(TabLayout.Tab tab) {

    appbarLayout.setBackgroundResource(mBgId[tab.getPosition()]);
    tipImage.setImageResource(mTipId[tab.getPosition()]);
  }
  public class FragmentListAdapter extends FragmentPagerAdapter{


    public FragmentListAdapter(FragmentManager fragmentManager) {
      super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
      return new ColorFragment();
    }

    @Override
    public int getCount() {
      return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return mTitles[position];
    }
  }
}
