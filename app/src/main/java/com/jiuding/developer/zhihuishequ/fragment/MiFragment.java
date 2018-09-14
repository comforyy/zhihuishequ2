package com.jiuding.developer.zhihuishequ.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jiuding.developer.zhihuishequ.R;
import com.jiuding.developer.zhihuishequ.activity.LoginActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by macbookair on 2017/9/17.
 */

public class MiFragment extends Fragment {

    private View mInflate;

    @InjectView(R.id.btn_login)
    Button mBtnLogin;

    public MiFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //防止重新加载数据
        if (mInflate == null) {
            mInflate = inflater.inflate(R.layout.fragment_mi, container, false);
        }
        ButterKnife.inject(this, mInflate);
        return mInflate;
    }

    @OnClick(R.id.btn_login)
    public void login(View view){
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
