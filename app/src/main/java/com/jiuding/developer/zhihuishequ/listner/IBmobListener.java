package com.jiuding.developer.zhihuishequ.listner;

import com.jiuding.developer.zhihuishequ.bean.FavorInfo;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by hongkl on 16/9/5.
 */
public interface IBmobListener {

    void sendMsgSucess();
    void  loginSucess();
    void queryFailure(BmobException e);
    void querySuccess(FavorInfo object);
}
