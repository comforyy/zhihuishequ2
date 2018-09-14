// Generated code from Butter Knife. Do not modify!
package com.jiuding.developer.zhihuishequ.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MiFragment$$ViewInjector {
  public static void inject(Finder finder, final com.jiuding.developer.zhihuishequ.fragment.MiFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624249, "field 'mBtnLogin' and method 'login'");
    target.mBtnLogin = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.login(p0);
        }
      });
  }

  public static void reset(com.jiuding.developer.zhihuishequ.fragment.MiFragment target) {
    target.mBtnLogin = null;
  }
}
