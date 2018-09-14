package com.jiuding.developer.zhihuishequ.function;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.jiuding.developer.zhihuishequ.R;
import com.jiuding.developer.zhihuishequ.adapter.BaokuanAdapter;
import com.jiuding.developer.zhihuishequ.bean.BaokuanBean;
import com.jiuding.developer.zhihuishequ.util.MyGridView;

import java.util.ArrayList;

/**
 * Created by macbookair on 2017/9/27.
 */

public class Baopingremai extends AppCompatActivity{

    private BaokuanAdapter mBaokuanAdapter;
    private MyGridView baokuan_gridview;
    private ImageView baokuan_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baopinremai);
        initview();
        baokuan();
    }

    private void initview() {
        baokuan_gridview = (MyGridView) findViewById(R.id.baokuan_gridview);
        //baokuan_back = (ImageView) findViewById(R.id.baokuan_back);
        /*baokuan_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
    }

    private void baokuan() {

        ArrayList<BaokuanBean> baokuanBeenlist=new ArrayList<>();

        BaokuanBean tuiJianBean1=new BaokuanBean("https://img10.360buyimg.com/n1/jfs/t3091/3/2891150794/153959/23076f22/57eb38c0Nf1a16f75.jpg",
                "泰国进口龙眼/1kg",
                "特级龙眼，美味珍珠，晶莹剔透，甘甜醇香，细腻多汁",
                "18.2",
                "16.9");
        BaokuanBean tuiJianBean=new BaokuanBean("https://img14.360buyimg.com/n1/jfs/t3046/265/544746786/200600/37296076/57baa5beNc13e05df.jpg",
                "红心火龙果/3个",
                "口感鲜甜爽滑",
                "25.3",
                "23.9");
        BaokuanBean tuiJianBean2=new BaokuanBean("https://img13.360buyimg.com/n1/jfs/t6037/335/5598056284/332107/784d677f/596c3ac4N43d78063.jpg",
                "凯特芒/1.5kg",
                "口感好,水分充足",
                "29.9",
                "27.9");
        BaokuanBean tuiJianBea3=new BaokuanBean("https://img12.360buyimg.com/n1/jfs/t3673/146/2556212473/182465/156a9302/58573358N99b4b581.jpg",
                "烟台红富士/2.1kg",
                "甜，脆，好吃，完美",
                "31.5",
                "29.9");
        BaokuanBean tuiJianBea4=new BaokuanBean("http://file06.16sucai.com/2016/0419/44459808f6ff16b58fb400b1fddf0f1e.jpg",
                "哈密瓜",
                "甜美无比 甘甜适口",
                "16",
                "12");
        BaokuanBean tuiJianBea5=new BaokuanBean("http://file06.16sucai.com/2016/0516/ed96ed353c6d72e85d1bc3e396137e3c.jpg",
                "草莓",
                "鲜美红嫩，果肉多汁",
                "23",
                "16");

        baokuanBeenlist.add(tuiJianBean1);
        baokuanBeenlist.add(tuiJianBean);
        baokuanBeenlist.add(tuiJianBea3);
        baokuanBeenlist.add(tuiJianBea4);
        baokuanBeenlist.add(tuiJianBea5);
        baokuanBeenlist.add(tuiJianBean2);

        mBaokuanAdapter = new BaokuanAdapter(this,baokuanBeenlist);
        baokuan_gridview.setAdapter(mBaokuanAdapter);

    }
}
