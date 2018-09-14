// Generated code from Butter Knife. Do not modify!
package com.jiuding.developer.zhihuishequ.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ZhihuiFragment$$ViewInjector {
  public static void inject(Finder finder, final com.jiuding.developer.zhihuishequ.fragment.ZhihuiFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624282, "field 'videoview'");
    target.videoview = (com.jiuding.developer.zhihuishequ.Open.CustomVideoView) view;
    view = finder.findRequiredView(source, 2131624283, "field 'openthedoor'");
    target.openthedoor = (com.jiuding.developer.zhihuishequ.Open.Openthedoor) view;
  }

  public static void reset(com.jiuding.developer.zhihuishequ.fragment.ZhihuiFragment target) {
    target.videoview = null;
    target.openthedoor = null;
  }
}
