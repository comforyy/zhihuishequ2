// Generated code from Butter Knife. Do not modify!
package com.jiuding.developer.zhihuishequ.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class RegisterActivity$$ViewInjector {
  public static void inject(Finder finder, final com.jiuding.developer.zhihuishequ.activity.RegisterActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624138, "field 'iv_re_back' and method 'onClick'");
    target.iv_re_back = (android.widget.ImageView) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624144, "field 'cb_Re_show_pwd'");
    target.cb_Re_show_pwd = (android.widget.CheckBox) view;
    view = finder.findRequiredView(source, 2131624141, "field 'et_photo'");
    target.et_photo = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131624143, "field 'et_pwd'");
    target.et_pwd = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131624146, "field 'et_re_pwd'");
    target.et_re_pwd = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131624148, "field 'bt_get_check_code' and method 'onClick'");
    target.bt_get_check_code = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  public static void reset(com.jiuding.developer.zhihuishequ.activity.RegisterActivity target) {
    target.iv_re_back = null;
    target.cb_Re_show_pwd = null;
    target.et_photo = null;
    target.et_pwd = null;
    target.et_re_pwd = null;
    target.bt_get_check_code = null;
  }
}
