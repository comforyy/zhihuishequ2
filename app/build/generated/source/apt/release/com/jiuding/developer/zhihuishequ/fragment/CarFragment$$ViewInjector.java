// Generated code from Butter Knife. Do not modify!
package com.jiuding.developer.zhihuishequ.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CarFragment$$ViewInjector {
  public static void inject(Finder finder, final com.jiuding.developer.zhihuishequ.fragment.CarFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624083, "field 'btnBack'");
    target.btnBack = (android.widget.Button) view;
    view = finder.findRequiredView(source, 2131624328, "field 'ckAll'");
    target.ckAll = (android.widget.CheckBox) view;
    view = finder.findRequiredView(source, 2131624329, "field 'tvShowPrice'");
    target.tvShowPrice = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131624330, "field 'tvSettlement'");
    target.tvSettlement = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131624332, "field 'btnEdit'");
    target.btnEdit = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131624326, "field 'list_shopping_cart'");
    target.list_shopping_cart = (android.widget.ListView) view;
  }

  public static void reset(com.jiuding.developer.zhihuishequ.fragment.CarFragment target) {
    target.btnBack = null;
    target.ckAll = null;
    target.tvShowPrice = null;
    target.tvSettlement = null;
    target.btnEdit = null;
    target.list_shopping_cart = null;
  }
}
