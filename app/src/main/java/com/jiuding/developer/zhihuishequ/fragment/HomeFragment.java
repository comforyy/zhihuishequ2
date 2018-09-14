package com.jiuding.developer.zhihuishequ.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.jiuding.developer.zhihuishequ.R;
import com.jiuding.developer.zhihuishequ.SearchActivity;
import com.jiuding.developer.zhihuishequ.activity.StopCarActivity;
import com.jiuding.developer.zhihuishequ.adapter.GalleryAdapter;
import com.jiuding.developer.zhihuishequ.adapter.MyGridAdapter;
import com.jiuding.developer.zhihuishequ.adapter.MyPagerAdapter;
import com.jiuding.developer.zhihuishequ.adapter.ShishuAdapter;
import com.jiuding.developer.zhihuishequ.adapter.TuiJianAdapter;
import com.jiuding.developer.zhihuishequ.bean.HomeIconInfo;
import com.jiuding.developer.zhihuishequ.bean.ShishuBean;
import com.jiuding.developer.zhihuishequ.bean.ShoppingCart;
import com.jiuding.developer.zhihuishequ.bean.TuiJianBean;
import com.jiuding.developer.zhihuishequ.bean.Wares;
import com.jiuding.developer.zhihuishequ.function.Baopingremai;
import com.jiuding.developer.zhihuishequ.function.Meisi;
import com.jiuding.developer.zhihuishequ.util.MyGridView;
import com.jiuding.developer.zhihuishequ.ywtpay.MainActivity;
import com.kesetel.call.library.Call;
import com.kesetel.call.library.listener.OnInitListener;
import com.kesetel.call.library.listener.OnStartListener;
import com.kesetel.call.library.ui.activity.CallMainActivity;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;
import static android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE;
import static com.jiuding.developer.zhihuishequ.R.id.gridView;

/**
 * Created by macbookair on 2017/9/17.
 */

public class HomeFragment extends Fragment {

    private View mInflate;
    /*
    首页圆形导航按钮
    */
    private List<View> mViews = new ArrayList<>();
    /**
     * gridView两页的数据
     */
    @InjectView(R.id.viewPager_text)
    ViewPager viewPager_text;
    private List<HomeIconInfo> mPagerOneData = new ArrayList<>();
    private List<HomeIconInfo> mPagerTwoData = new ArrayList<>();
    /*轮播图*/
    @InjectView(R.id.slider)
    SliderLayout mSliderLayout;
    @InjectView(R.id.custom_indicator)
    PagerIndicator indicator;
    /*倒计时*/
    /*@InjectView(R.id.timeout)
    CountdownView timeout;*/
    /*秒杀*/
    @InjectView(R.id.id_recyclerview_horizontal)
    RecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mDatas;
    /*推荐*/
    @InjectView(R.id.tuijian_gridview)
    MyGridView tuijian_gridview;
    /*时蔬*/
    @InjectView(R.id.shishu_gridview)
    MyGridView shishu_gridview;
    Context context;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //防止重新加载数据
        if (mInflate == null) {
            mInflate = inflater.inflate(R.layout.fragment_home,container,false);
            ButterKnife.inject(this, mInflate);

            initData();
            initView();
            initSlider();//轮播图
            miaosha();//秒杀
            tuijain();//推荐
            carshishu();
            initset();/*沉浸式通知栏*/
            ZXingLibrary.initDisplayOpinion(getActivity());
        }



        ButterKnife.inject(this, mInflate);
        return mInflate;

    }

    private void initset() {

    }


    private void carshishu() {
        final ArrayList<ShishuBean>shishuBeenList = new ArrayList<>();

        ShishuBean shishuBean1 = new ShishuBean("https://img11.360buyimg.com/n1/jfs/t3655/363/2056131123/73089/ff341da/5843da08N233e4886.jpg",
                "圆白菜/500g",
                "5.2","5.5");
        ShishuBean shishuBean2 = new ShishuBean("https://img14.360buyimg.com/n7/jfs/t4297/120/375562832/241785/c162c78b/58b3c779Na1ec50a0.jpg",
                "上海青/400g",
                "7.5","7.9");
        ShishuBean shishuBean3 = new ShishuBean("https://img13.360buyimg.com/n1/jfs/t5266/90/352723115/531374/b73117c5/58fdb912N5fc81862.jpg",
                "贝贝番茄/500g",
                "14.8","15.6");
        ShishuBean shishuBean4 = new ShishuBean("https://img13.360buyimg.com/n1/jfs/t3526/310/2014375487/500788/99978c40/583d31d0N4b3c83e0.jpg",
                " 西兰花/300g",
                "6.9","7.3");
        shishuBeenList.add(shishuBean1);
        shishuBeenList.add(shishuBean2);
        shishuBeenList.add(shishuBean3);
        shishuBeenList.add(shishuBean4);
        ShishuAdapter adapter = new ShishuAdapter(getActivity(),shishuBeenList);
        shishu_gridview.setAdapter(adapter);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},PARCELABLE_WRITE_RETURN_VALUE);
        }

        /*处理扫描结果*/
        if (requestCode == 0){

            if (null !=data){
                Bundle bundle = data.getExtras();
                if (bundle == null){
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS){
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(),"解析结果"+result,Toast.LENGTH_SHORT).show();

                    String s = "";

                    Random random = new Random(System.currentTimeMillis());
                    s=s+ random.nextInt(1000000000);

                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("random",s);
                    intent.putExtra("msg",result);
                    startActivity(intent);
                }else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED){
                    Toast.makeText(getActivity(),"解析结果",Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    private void tuijain() {

        final ArrayList<TuiJianBean>tuiJianlist=new ArrayList<>();

        TuiJianBean tuiJianBean1=new TuiJianBean("http://file06.16sucai.com/2016/0516/ed96ed353c6d72e85d1bc3e396137e3c.jpg",
                "草莓",
                "鲜美红嫩，果肉多汁",
                "23.6",
                "16.9");
        TuiJianBean tuiJianBean=new TuiJianBean("http://file06.16sucai.com/2016/0419/44459808f6ff16b58fb400b1fddf0f1e.jpg",
                "哈密瓜",
                "甜美无比 甘甜适口",
                "16.3",
                "12.8");
        TuiJianBean tuiJianBean2=new TuiJianBean("https://img12.360buyimg.com/n1/jfs/t3673/146/2556212473/182465/156a9302/58573358N99b4b581.jpg",
                "烟台红富士/2.1kg",
                "甜，脆，好吃，完美",
                "31.5",
                "29.9");
        TuiJianBean tuiJianBea3=new TuiJianBean("https://img13.360buyimg.com/n1/jfs/t6037/335/5598056284/332107/784d677f/596c3ac4N43d78063.jpg",
                "凯特芒/1.5kg",
                "口感好,水分充足",
                "29.9",
                "27.9");
        TuiJianBean tuiJianBea4=new TuiJianBean("https://img14.360buyimg.com/n1/jfs/t3046/265/544746786/200600/37296076/57baa5beNc13e05df.jpg",
                "红心火龙果/3个",
                "口感鲜甜爽滑",
                "25.3",
                "23.9");
        TuiJianBean tuiJianBea5=new TuiJianBean("https://img10.360buyimg.com/n1/jfs/t3091/3/2891150794/153959/23076f22/57eb38c0Nf1a16f75.jpg",
                "泰国进口龙眼/1kg",
                "特级龙眼，美味珍珠，晶莹剔透，甘甜醇香，细腻多汁",
                "18.2",
                "16.9");

        tuiJianlist.add(tuiJianBean1);
        tuiJianlist.add(tuiJianBean);
        tuiJianlist.add(tuiJianBea3);
        tuiJianlist.add(tuiJianBea4);
        tuiJianlist.add(tuiJianBea5);
        tuiJianlist.add(tuiJianBean2);
        final TuiJianAdapter adapter=new TuiJianAdapter(getActivity(),tuiJianlist);
        tuijian_gridview.setAdapter(adapter);
        adapter.setOnItemDeleteClickListener(new TuiJianAdapter.onItemDeleteListener() {
            @Override
            public void onDeleteClick(int position) {
                Toast.makeText(getActivity(),"购物车+1",Toast.LENGTH_SHORT).show();

            }
        });

    }

    public ShoppingCart convertData(Wares item){

        ShoppingCart cart = new ShoppingCart();

        cart.setId(item.getId());
        cart.setDescription(item.getDescription());
        cart.setImgUrl(item.getImgUrl());
        cart.setName(item.getName());
        cart.setPrice(item.getPrice());

        return cart;
    }

    private void miaosha() {
        mDatas = new ArrayList<>(Arrays.asList(R.mipmap.x1,
                R.mipmap.x2, R.mipmap.x4, R.mipmap.x3, R.mipmap.x4));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new GalleryAdapter(getActivity(),mDatas);
        mRecyclerView.setAdapter(mAdapter);

    }

    /*private void initTime() {
        timeout.start(600000);
        for (int time=0;time<100;time++){
            timeout.updateShow(time);
        }
    }*/

    private void initSlider() {
        TextSliderView textSliderView = new TextSliderView(this.getActivity());
        textSliderView.image("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533386468237&di=7355e600b9b0bd41332005aeae88703b&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01984556e568d832f875520f9494c0.jpg%401280w_1l_2o_100sh.png");
        textSliderView.description("停车系统");
        textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(getActivity(),"新鲜蔬菜",Toast.LENGTH_LONG).show();

            }
        });

        TextSliderView textSliderView2 = new TextSliderView(this.getActivity());
        textSliderView2.image("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505279912576&di=d3ba16936e898a40d5d09515f8e8f0e5&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F67%2F68%2F69Z58PICv2p.jpg");
        textSliderView2.description("冰爽夏日");

        textSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(getActivity(),"冰爽夏日",Toast.LENGTH_LONG).show();

            }
        });



        TextSliderView textSliderView3 = new TextSliderView(this.getActivity());
        textSliderView3.image("http://img.ivsky.com/img/bizhi/pre/201604/05/pai.jpg");
        textSliderView3.description("巧克力派");


        textSliderView3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(getActivity(),"巧克力派",Toast.LENGTH_LONG).show();

            }
        });

        mSliderLayout.addSlider(textSliderView);
        mSliderLayout.addSlider(textSliderView2);
        mSliderLayout.addSlider(textSliderView3);

        //mSliderLayout.setCustomIndicator(indicator);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        mSliderLayout.setDuration(3000);

        mSliderLayout.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {


                Log.d(TAG,"onPageScrolled");

            }

            @Override
            public void onPageSelected(int i) {

                Log.d(TAG,"onPageSelected");
            }

            @Override
            public void onPageScrollStateChanged(int i) {

                Log.d(TAG,"onPageScrollStateChanged");
            }
        });
    }

    private void initData() {
        //获取资源文件的数据
        String[] iconName = getResources().getStringArray(R.array.home_bar_labels);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.home_bar_icon);

        for (int i = 0; i < iconName.length; i++) {
            if (i < 8) {
                mPagerOneData.add(new HomeIconInfo(iconName[i], typedArray.getResourceId(i, 0)));
            } else {
                mPagerTwoData.add(new HomeIconInfo(iconName[i], typedArray.getResourceId(i, 0)));
            }
        }
    }

    private void initView() {

        View pagerOne = LayoutInflater.from(getActivity()).inflate(R.layout.home_gridview, null);
        GridView gridView01 = pagerOne.findViewById(gridView);
        gridView01.setAdapter(new MyGridAdapter(mPagerOneData, getActivity()));
        gridView01.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gridView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Toast.makeText(getActivity(),"停车收费",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(), Meisi.class));
                        break;
                    case 1:

                        Call.init(getActivity(), new OnInitListener() {
                            @Override
                            public void onCompleted() {
                                Call.getInstance().start("13714798167", new OnStartListener() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError(String s) {

                                    }
                                });
                            }

                            @Override
                            public void onError(String s) {

                            }
                        });

                        /*Call.init(getApplicationContext(), new OnInitListener() {
                            @Override
                            public void onCompleted() {
                                Call.getInstance().start("13714798167", new OnStartListener() {
                                    @Override
                                    public void onSuccess() {
                                        Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onError(String s) {
                                        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            @Override
                            public void onError(String s) {

                            }
                        });
*/
                        Intent activity = new Intent(getActivity(), CallMainActivity.class);
                        startActivity(activity);
                        break;
                    case 2:
                        Toast.makeText(getActivity(),"抱歉！功能暂未开放",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Intent intent = new Intent(getActivity(), Baopingremai.class);
                        startActivity(intent);
                        break;
                    case 4:
                        Intent intent1 = new Intent(getActivity(), StopCarActivity.class);
                        startActivity(intent1);
                        break;
                    case 5:
                        Toast.makeText(getActivity(),"",Toast.LENGTH_SHORT).show();

                        //Intent LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.menmo.gateye");
                        Intent LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.wedone.smarthic.app");
                        startActivity(LaunchIntent);

                        break;
                }
            }
        });

        View pagerTwo = LayoutInflater.from(getActivity()).inflate(R.layout.home_gridview, null);
        GridView gridView02 = (GridView) pagerTwo.findViewById(gridView);
        gridView02.setAdapter(new MyGridAdapter(mPagerTwoData,getActivity()));
        gridView02.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gridView02.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        mViews.add(pagerOne);
        mViews.add(pagerTwo);
        viewPager_text.setAdapter(new MyPagerAdapter(mViews));

    }

    @OnClick({R.id.scan_img, R.id.msg_iv,R.id.location_lay,R.id.inputLL,R.id.city_name})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scan_img:
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, 0);
                break;
            /*case R.id.msg_iv:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;*/
            case R.id.inputLL:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.location_lay:
                break;
            case R.id.city_name:
                /*Intent intent1= new Intent(getActivity(), MapActivity.class);
                startActivityForResult(intent1,0);*/
        }
    }

}
