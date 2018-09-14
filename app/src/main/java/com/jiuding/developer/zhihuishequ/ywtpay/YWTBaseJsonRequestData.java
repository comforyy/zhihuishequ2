package com.jiuding.developer.zhihuishequ.ywtpay;

import java.io.Serializable;

/**
 * Created by macbookair on 2017/10/19.
 */

public class YWTBaseJsonRequestData<T> implements Serializable {

    private static final long serialVersionUID = 1390585765269445243L;
    String version = "1.0";//接口版本号
    String charset = "UTF-8";//参数编码
    String sign;//报文签名
    String signType = "SHA-256";//签名算法
    T reqData;//请求数据

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public void setReqData(T reqData) {
        this.reqData = reqData;
    }
}

