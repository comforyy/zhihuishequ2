package com.jiuding.developer.zhihuishequ.nohttp;

import com.yolanda.nohttp.rest.Response;


public interface HttpListner<T> {
    void onSucceed(int what, Response<T> response);
    void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis);

}
