package com.jiuding.developer.zhihuishequ.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbookair on 2017/9/18.
 */

public class CommenAdapter<T> extends android.widget.BaseAdapter {
    List<T> mData = new ArrayList<>();
    public CommenAdapter(List<T> data) {
        mData = data;
    }
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
