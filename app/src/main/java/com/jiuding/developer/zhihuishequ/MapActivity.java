package com.jiuding.developer.zhihuishequ;

import android.support.v7.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {
   /* private MapView mMapView;
    private BaiduMap mBaiduMap;
    private boolean isFirstLoc = true;
    *//*
    * 百度地图出现空白或者都是白格子的问题
    * 1、模拟器没网络，没有开网络权限
    * 2、包名或者sha1值出错
    * 3、
    * *//*
    *//*定位相关*//*
    LocationClient mLocClient;
    public  MyLocationListener myListener = new MyLocationListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_map);
         *//*mMapView = (MapView) findViewById(R.id.mapView);
        mBaiduMap = mMapView.getMap();*//*
        initBaiduMap();*/

    }
   /* //初始化地图
    private void initBaiduMap() {
        // 地图初始化
        mMapView = (MapView) findViewById(R.id.mapView);
        mBaiduMap = mMapView.getMap();
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        // 定位初始化
        mLocClient = new LocationClient(this);
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        mLocClient.setLocOption(option);
        mLocClient.start();
    }*/

    /*@Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        // 退出时销毁定位
        mLocClient.stop();
        // 关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }*/

    /*实现定位的sdk的监听函数*//*
    public class  MyLocationListener implements BDLocationListener{

        @Override
        public void onReceiveLocation(BDLocation location) {

            if (mMapView == null || location == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            }
        }
    }
}*/
