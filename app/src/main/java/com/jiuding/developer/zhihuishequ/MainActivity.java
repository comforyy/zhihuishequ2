package com.jiuding.developer.zhihuishequ;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.jiuding.developer.zhihuishequ.SplashView.SplashView;
import com.jiuding.developer.zhihuishequ.fragment.CarFragment;
import com.jiuding.developer.zhihuishequ.fragment.ClassifyFragment;
import com.jiuding.developer.zhihuishequ.fragment.HomeFragment;
import com.jiuding.developer.zhihuishequ.fragment.MiFragment;
import com.jiuding.developer.zhihuishequ.fragment.ZhihuiFragment;

import cn.bmob.v3.Bmob;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private Class[] clas = new Class[] {HomeFragment.class, ClassifyFragment.class, ZhihuiFragment.class, CarFragment.class,
            MiFragment.class };
    private int images[] = new int[] {R.drawable.tab_1_selector, R.drawable.tab_2_selector,1, R.drawable.tab_4_selector,
            R.drawable.tab_5_selector };
    private ImageView main_image_center;
    private TextView main_tv_final;
    private TextView mBottom_center;
    private FragmentTabHost mTabHost;

    //private IWXAPI api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        /*api = WXAPIFactory.createWXAPI(this, Constants.APP_ID, false);
        api.registerApp(Constants.APP_ID);*/
        Bmob.initialize(this, "e9c3deb755bc2ca6ce331c1882db266d");

        // call after setContentView(R.layout.activity_sample);
        SplashView.showSplashView(this, 2, R.drawable.default_img, new SplashView.OnSplashViewActionListener() {
            @Override
            public void onSplashImageClick(String actionUrl) {
                Log.d("SplashView", "img clicked. actionUrl: " + actionUrl);
                Toast.makeText(MainActivity.this, "img clicked.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSplashViewDismiss(boolean initiativeDismiss) {
                Log.d("SplashView", "dismissed, initiativeDismiss: " + initiativeDismiss);
            }
        });

        // call this method anywhere to update splash view data
        SplashView.updateSplashData(this, "http://bmob-cdn-14973.b0.upaiyun.com/2017/12/08/ea176ca940bb1867807f89e08765027c.png", "http://www.szjiuding.com/");



    }

    private void initUI() {
        //底部中间按钮控件
        main_image_center = (ImageView) findViewById(R.id.main_image_center);
        main_tv_final = (TextView) findViewById(R.id.main_tv_final);
        main_image_center.setImageResource(R.mipmap.circle);
        mBottom_center = (TextView) findViewById(R.id.main_tv_final);
        main_image_center.setOnClickListener(this);
        mBottom_center.setOnClickListener(this);
        main_tv_final.setOnClickListener(this);

        String[] tabIndicatorArray = getResources().getStringArray(R.array.arr_tab_indicator);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        LayoutInflater inflater = getLayoutInflater();
        for (int i = 0; i < images.length; i++) {
            View indicatorView = inflater.inflate(R.layout.list_item_viewpagerindicator, null);
            TextView tvIndicator = (TextView) indicatorView.findViewById(R.id.tv_title_indicator);
            tvIndicator.setText(tabIndicatorArray[i]);
            ImageView imageView = (ImageView) indicatorView.findViewById(R.id.ima_indicator);
            imageView.setImageResource(images[i]);
            //Typist添加tab切换事件
            mTabHost.addTab(mTabHost.newTabSpec("tab"+i).setIndicator(indicatorView), clas[i], null);
            //#af0000
            mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

                @Override
                public void onTabChanged(String tabId) {
                    switch (tabId)
                    {
                        case "tab2":
                            main_image_center.setImageResource(R.mipmap.circle_pre);
                            mBottom_center.setTextColor(Color.parseColor("#FC2985"));
                            break;
                        default:
                            main_image_center.setImageResource(R.mipmap.circle);
                            mBottom_center.setTextColor(Color.parseColor("#FC2985"));
                            break;
                    }
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.main_image_center:
                mTabHost.setCurrentTab(2);
                break;
            case R.id.main_tv_final:
                mTabHost.setCurrentTab(2);
                break;
            default:
                break;
        }
    }
}

