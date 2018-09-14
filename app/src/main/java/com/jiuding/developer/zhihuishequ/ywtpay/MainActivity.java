package com.jiuding.developer.zhihuishequ.ywtpay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.jiuding.developer.zhihuishequ.R;

/**
 * Created by macbookair on 2017/10/19.
 */

public class MainActivity extends AppCompatActivity {

    private YWTWebView webview;
    /**签约地址*/
    private static final String signUrl = "http://121.15.180.66:801/mobilehtml/DebitCard/M_NetPay/OneNetRegister/NP_BindCard.aspx";
    /**支付地址地址*/
    private static final String payUrl = "http://121.15.180.66:801/NetPayment/BaseHttp.dll?MB_EUserPay";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ywtpay);
        init();
    }

    public void init(){
        webview = (YWTWebView) findViewById(R.id.webview);
        LoadUrl();
    }
    //119.29.97.242

    private void LoadUrl() {
        String s = getIntent().getStringExtra("random");
        String num = getIntent().getStringExtra("msg");

if (num!=null){
    String jsondata = "jsonRequestData="+
            getJsonRequestData(s,num,"30","http://116.25.100.203:80/payNotice","http://119.29.97.242/php/queryAccountedOrder.html","http://www.baidu.com","20170317008","20170317005");
    webview.postUrl(payUrl,jsondata.getBytes());
}else {
    String jsondata = "jsonRequestData="+
            getJsonRequestData("2017101711","0.01","30","http://116.25.100.203:80/payNotice","http://119.29.97.242/php/queryAccountedOrder.html","http://www.baidu.com","20170317008","20170317005");
    webview.postUrl(payUrl,jsondata.getBytes());
}


    }

    /**
     * 获得支付请求的参数
     * @param orderId 订单号
     * @param due 金额
     * @param signInformUrl 签约成功通知后台的地址
     * @param payInformUrl 支付成功通知后台的地址
     * @param returnUrl 支付成功的返回商户的地址
     * @param agrNo 协议号
     * @param merchantSerialNo 协议开通的流水号
     * @return
     */
    private String getJsonRequestData(String orderId,String due,String expireTimeSpan,String signInformUrl,String payInformUrl,String returnUrl,String agrNo,String merchantSerialNo){
        YWTBaseJsonRequestData<YWTPayReqData> requestData = new YWTBaseJsonRequestData<>();
        //YWTBaseJsonRequestData<YWTPayReqData> requestData = new YWTBaseJsonRequestData<>();
        YWTPayReqData ywtPayReqData = new YWTPayReqData(
                YWTUtil.getCurrentTime(),
                YWTConfig.branchNo,
                YWTConfig.merchentNo,
                YWTUtil.getYWTOrderTime(),
                orderId,
                due,
                expireTimeSpan,
                signInformUrl,
                payInformUrl,
                agrNo,
                merchantSerialNo,
                returnUrl
        );
        requestData.setSign(YWTUtil.getSign(ywtPayReqData));
        requestData.setReqData(ywtPayReqData);
        String json = new Gson().toJson(requestData);
        System.out.println("这是报文"+json);
        return json;
    }

}
