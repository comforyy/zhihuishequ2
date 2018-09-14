package com.jiuding.developer.zhihuishequ.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiuding.developer.zhihuishequ.R;
import com.jiuding.developer.zhihuishequ.bean.MiaoShaBean;

import java.util.ArrayList;


/**
 * Created by Tom on 2017/8/21.
 */

public class MiaoshaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MiaoShaBean> miaoshalist;
    public MiaoshaAdapter(Context context, ArrayList<MiaoShaBean> miaoshalist){
        this.context = context;
        this.miaoshalist = miaoshalist;
    }
    @Override
    public int getCount() {
        return miaoshalist.size();
    }

    @Override
    public Object getItem(int position) {
        return miaoshalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       GridViewHolder holder = null;
        MiaoShaBean miaoShaBean = miaoshalist.get(position);
        if (convertView ==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.miaosha_layout,parent,false);
           holder = new GridViewHolder();
            convertView.setTag(holder);
            holder.miaosha_img= (ImageView) convertView.findViewById(R.id.miaosha_img);
            holder.tv_miaosha_shijia= (TextView) convertView.findViewById(R.id.tv_miaosha_shijia);
        }


        return convertView;
    }
    public class GridViewHolder{

        ImageView miaosha_img;
        TextView tv_miaosha_shijia;
        TextView tv_miaosha_yuanjia;

    }
}
