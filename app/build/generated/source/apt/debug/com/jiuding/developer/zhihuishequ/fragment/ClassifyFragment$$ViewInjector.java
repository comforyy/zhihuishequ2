// Generated code from Butter Knife. Do not modify!
package com.jiuding.developer.zhihuishequ.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ClassifyFragment$$ViewInjector {
  public static void inject(Finder finder, final com.jiuding.developer.zhihuishequ.fragment.ClassifyFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624231, "field 'lv_menu'");
    target.lv_menu = (android.widget.ListView) view;
    view = finder.findRequiredView(source, 2131624233, "field 'tv_title'");
    target.tv_title = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131624232, "field 'lv_home'");
    target.lv_home = (android.widget.ListView) view;
  }

  public static void reset(com.jiuding.developer.zhihuishequ.fragment.ClassifyFragment target) {
    target.lv_menu = null;
    target.tv_title = null;
    target.lv_home = null;
  }
}
