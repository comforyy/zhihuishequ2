package com.jiuding.developer.zhihuishequ.fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jiuding.developer.zhihuishequ.Open.CustomVideoView;
import com.jiuding.developer.zhihuishequ.Open.Openthedoor;
import com.jiuding.developer.zhihuishequ.R;

import java.util.Random;
import java.util.Timer;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by macbookair on 2017/9/17.
 */

public class ZhihuiFragment extends Fragment {


    private View mInflate;
    //创建播放视频的控件对象

    @InjectView(R.id.videoview)
     CustomVideoView videoview;
    @InjectView(R.id.slideUnlockView)
     Openthedoor openthedoor;

     Random mRandom = new Random();

     Timer mTimer = new Timer();

    public ZhihuiFragment() {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if (mInflate == null) {

            mInflate = inflater.inflate(R.layout.fragment_zhihui,container,false);

        }

        ButterKnife.inject(this, mInflate);

        initview();

        return mInflate;
    }

    private void initview() {

        openthedoor.setOnUnLockListener(new Openthedoor.OnUnLockListener() {
            @Override
            public void setUnLocked(boolean lock) {
                Toast.makeText(getContext(),"欢迎回家",Toast.LENGTH_SHORT).show();
                Intent LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.menmo.gateye");
                startActivity(LaunchIntent);

                /*Intent intent = new Intent(getContext(), FragmentIndex.class);
                startActivity(intent);*/
            }
        });

        //设置播放加载路径
        videoview.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video));
        //播放
        videoview.start();
        //循环播放
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });

    }
}
