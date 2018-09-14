package com.jiuding.developer.zhihuishequ.function;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jiuding.developer.zhihuishequ.R;
import com.jiuding.developer.zhihuishequ.adapter.MeisiAdapter;
import com.jiuding.developer.zhihuishequ.bean.MeiShiBean;
import com.jiuding.developer.zhihuishequ.util.MyGridView;

import java.util.ArrayList;

/**
 * Created by macbookair on 2017/10/27.
 */

public class Meisi extends AppCompatActivity {

    private MeisiAdapter mMeisiAdapter;
    private MyGridView meishi_gridview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meishi);
        initview();
        meishi();
    }

    private void initview() {
        meishi_gridview = (MyGridView) findViewById(R.id.meishi_gridview);
        //baokuan_back = (ImageView) findViewById(R.id.baokuan_back);
        /*baokuan_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
    }

    private void meishi() {

        ArrayList<MeiShiBean> meiShiBeenList=new ArrayList<>();

        MeiShiBean meiShiBeen1=new MeiShiBean("https://img11.360buyimg.com/n1/jfs/t4657/229/1153934628/260939/2f8487ec/58d9c423Nf4991a10.jpg",
                "牛肉干/100g",
                "五香牛肉条100g/袋 肉类零食店特产美食小吃",
                "16.2",
                "15.9");
        MeiShiBean meiShiBean=new MeiShiBean("https://img12.360buyimg.com/n1/jfs/t9943/291/1790058551/405982/dd9a37f1/59e6cfaaNb83d1b81.jpg",
                "周黑鸭",
                "香辣可口",
                "28",
                "25。3");
        MeiShiBean meiShiBean2=new MeiShiBean("https://img14.360buyimg.com/n0/jfs/t5950/83/4041661524/412619/40b36137/595c431eNbede4a32.jpg",
                "肉脯肉干礼盒",
                "香辣零食小吃美食 卤味大礼包507g/盒",
                "69.9",
                "57.9");
        MeiShiBean meiShiBean3=new MeiShiBean("https://img12.360buyimg.com/n1/jfs/t5563/359/96196814/416984/e52e59c0/58f88d38Nfb47fff6.jpg",
                "牛肉丝",
                "牛肉丝200g/袋 小吃特产美食牛肉干",
                "21.5",
                "19.9");
        MeiShiBean meiShiBean4=new MeiShiBean("https://img14.360buyimg.com/n1/s546x546_jfs/t8833/36/1764459421/198098/563bdfdb/59bf618aN84f77332.jpg",
                "多力多滋",
                "Doritos（多力多滋）休闲零食 276g 劲脆套装",
                "16.5",
                "12");
        MeiShiBean meiShiBean5=new MeiShiBean("https://img11.360buyimg.com/n1/jfs/t4465/327/44522049/362826/56f15e67/58c89b6bNbce5b98b.jpg",
                "猪脆骨零食",
                "香辣奥尔良美食 猪软骨卤味熟食 肉类小吃150g",
                "16.9",
                "14.5");

        meiShiBeenList.add(meiShiBean);
        meiShiBeenList.add(meiShiBean2);
        meiShiBeenList.add(meiShiBean3);
        meiShiBeenList.add(meiShiBean4);
        meiShiBeenList.add(meiShiBeen1);
        meiShiBeenList.add(meiShiBean5);

        mMeisiAdapter = new MeisiAdapter(this,meiShiBeenList);
        meishi_gridview.setAdapter(mMeisiAdapter);

    }
}
