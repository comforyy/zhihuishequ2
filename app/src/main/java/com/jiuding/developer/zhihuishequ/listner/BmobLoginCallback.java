package com.jiuding.developer.zhihuishequ.listner;

import com.jiuding.developer.zhihuishequ.bean.FavorInfo;
import com.jiuding.developer.zhihuishequ.bean.GoodsPayInfo;

import java.util.List;

import cn.bmob.v3.exception.BmobException;

public abstract class BmobLoginCallback implements IBmobListener {


    public void queryOrderSuccess(List<GoodsPayInfo> object) {

    }


    public void queryOrderFailure(BmobException e) {

    }

    @Override
    public void querySuccess(FavorInfo object) {

    }

    @Override
    public void queryFailure(BmobException e) {

    }


    public void queryAllSuccess(List<FavorInfo> object) {

    }


    public void queryAllFailure(BmobException e) {

    }
}