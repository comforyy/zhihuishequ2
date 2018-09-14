// Generated code from Butter Knife. Do not modify!
package com.jiuding.developer.zhihuishequ.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class LoginActivity$$ViewInjector {
  public static void inject(Finder finder, final com.jiuding.developer.zhihuishequ.activity.LoginActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624126, "field 'cb_show_pwd'");
    target.cb_show_pwd = (android.widget.CheckBox) view;
    view = finder.findRequiredView(source, 2131624118, "field 'iv_back' and method 'onClick'");
    target.iv_back = (android.widget.ImageView) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624119, "field 'tv_register' and method 'onClick'");
    target.tv_register = (android.widget.TextView) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624123, "field 'Ed_username'");
    target.Ed_username = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131624125, "field 'Ed_password'");
    target.Ed_password = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131624127, "field 'quick_login_btn' and method 'onClick'");
    target.quick_login_btn = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  public static void reset(com.jiuding.developer.zhihuishequ.activity.LoginActivity target) {
    target.cb_show_pwd = null;
    target.iv_back = null;
    target.tv_register = null;
    target.Ed_username = null;
    target.Ed_password = null;
    target.quick_login_btn = null;
  }
}
