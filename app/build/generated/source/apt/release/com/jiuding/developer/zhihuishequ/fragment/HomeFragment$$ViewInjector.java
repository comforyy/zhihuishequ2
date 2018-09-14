// Generated code from Butter Knife. Do not modify!
package com.jiuding.developer.zhihuishequ.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class HomeFragment$$ViewInjector {
  public static void inject(Finder finder, final com.jiuding.developer.zhihuishequ.fragment.HomeFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624236, "field 'viewPager_text'");
    target.viewPager_text = (android.support.v4.view.ViewPager) view;
    view = finder.findRequiredView(source, 2131624234, "field 'mSliderLayout'");
    target.mSliderLayout = (com.daimajia.slider.library.SliderLayout) view;
    view = finder.findRequiredView(source, 2131624235, "field 'indicator'");
    target.indicator = (com.daimajia.slider.library.Indicators.PagerIndicator) view;
    view = finder.findRequiredView(source, 2131624237, "field 'mRecyclerView'");
    target.mRecyclerView = (android.support.v7.widget.RecyclerView) view;
    view = finder.findRequiredView(source, 2131624238, "field 'tuijian_gridview'");
    target.tuijian_gridview = (com.jiuding.developer.zhihuishequ.util.MyGridView) view;
    view = finder.findRequiredView(source, 2131624239, "field 'shishu_gridview'");
    target.shishu_gridview = (com.jiuding.developer.zhihuishequ.util.MyGridView) view;
    view = finder.findRequiredView(source, 2131624291, "method 'onClick'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624293, "method 'onClick'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624288, "method 'onClick'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624295, "method 'onClick'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624289, "method 'onClick'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  public static void reset(com.jiuding.developer.zhihuishequ.fragment.HomeFragment target) {
    target.viewPager_text = null;
    target.mSliderLayout = null;
    target.indicator = null;
    target.mRecyclerView = null;
    target.tuijian_gridview = null;
    target.shishu_gridview = null;
  }
}
