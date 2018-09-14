package com.jiuding.developer.zhihuishequ.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.jiuding.developer.zhihuishequ.R;
import com.jiuding.developer.zhihuishequ.adapter.stopcar.StopCarGridAdapter;
import com.jiuding.developer.zhihuishequ.util.MyGridView;


/**
 * Created by macbookair on 2017/10/25.
 */

public class StopCarActivity extends AppCompatActivity {

    private SliderLayout Stop_slider;
    private PagerIndicator stop_custom_indicator;
    private MyGridView gridview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carstop);
        initview();
        initSlider();
    }

    private void initview() {
        Stop_slider = (SliderLayout) findViewById(R.id.Stop_slider);
        stop_custom_indicator = (PagerIndicator) findViewById(R.id.stop_custom_indicator);
        gridview=(MyGridView) findViewById(R.id.stopcar_gridview);
        gridview.setAdapter(new StopCarGridAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        startActivity(new Intent(StopCarActivity.this,StopCarMsg.class));
                        break;
                }
            }
        });
    }

    private void initSlider() {

        TextSliderView textSliderView = new TextSliderView(this);
        textSliderView.image("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509097354040&di=116779dd44d9646ad3af22227a8fa516&imgtype=0&src=http%3A%2F%2Ffile5.youboy.com%2Fd%2F175%2F15%2F51%2F3%2F434993.jpg");
        textSliderView.description("九鼎智慧停车场");
        textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(StopCarActivity.this,"九鼎智慧停车场",Toast.LENGTH_LONG).show();

            }
        });

        TextSliderView textSliderView2 = new TextSliderView(this);
        textSliderView2.image("/uploads/allimg/170711/1_170711182149_1.jpg");
        textSliderView2.description("智慧社区广告门");

        textSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(StopCarActivity.this,"智慧社区广告门",Toast.LENGTH_LONG).show();

            }
        });



        TextSliderView textSliderView3 = new TextSliderView(this);
        textSliderView3.image("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1926397631,1009273850&fm=27&gp=0.jpg");
        textSliderView3.description("智慧停车");


        textSliderView3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(StopCarActivity.this,"智慧停车",Toast.LENGTH_LONG).show();

            }
        });

        Stop_slider.addSlider(textSliderView);
        Stop_slider.addSlider(textSliderView2);
        Stop_slider.addSlider(textSliderView3);

        //mSliderLayout.setCustomIndicator(indicator);
        Stop_slider.setCustomAnimation(new DescriptionAnimation());
        Stop_slider.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        Stop_slider.setDuration(3000);

        Stop_slider.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {


                //Log.d(TAG,"onPageScrolled");

            }

            @Override
            public void onPageSelected(int i) {

                //Log.d(TAG,"onPageSelected");
            }

            @Override
            public void onPageScrollStateChanged(int i) {

                //Log.d(TAG,"onPageScrollStateChanged");
            }
        });

    }


}
