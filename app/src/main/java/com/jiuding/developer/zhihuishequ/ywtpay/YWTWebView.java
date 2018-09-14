package com.jiuding.developer.zhihuishequ.ywtpay;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by macbookair on 2017/10/19.
 */

public class YWTWebView extends WebView {

    public YWTWebView(Context context){
        super(context);
        initWebView();
    }

    public YWTWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWebView();
    }

    public YWTWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initWebView();
    }


    private void initWebView(){
        setWebViewSetting();
        setWebViewClient(new YWTWebViewClient());
    }

    /**
     * 对webview的相关配置
     */
    private void setWebViewSetting(){
        // 对WebView进行设置
        WebSettings set = getSettings();
        // 支持JS
        set.setJavaScriptEnabled(true);
        set.setSaveFormData(false);
        set.setSavePassword(false);
        set.setSupportZoom(false);
    }
}

