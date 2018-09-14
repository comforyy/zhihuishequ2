package com.jiuding.developer.zhihuishequ.adapter;


import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiuding.developer.zhihuishequ.R;
import com.jiuding.developer.zhihuishequ.bean.BaokuanBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by macbookair on 2017/9/27.
 */

public class BaokuanAdapter extends android.widget.BaseAdapter {

    CardView mCardView;
    private Context context;


    private ArrayList<BaokuanBean> mBaokuanBeenlist;
    public BaokuanAdapter(Context context, ArrayList<BaokuanBean> mBaokuanBeenlist){
        this.context = context;
        this.mBaokuanBeenlist = mBaokuanBeenlist;
    }
    @Override
    public int getCount() {
        return mBaokuanBeenlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mBaokuanBeenlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GridViewHolder holder = null;
        BaokuanBean baokuanBean = mBaokuanBeenlist.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.baokuan_item,parent,false);
        holder =new GridViewHolder();
        convertView.setTag(holder);
        holder.tbaokuan_img= (ImageView) convertView.findViewById(R.id.tbaokuan_img);

        holder.car_tbaokuan_img = convertView.findViewById(R.id.tbaokuan_car_imag);



        holder.tbaokuan_title = (TextView) convertView.findViewById(R.id.tbaokuan_title);

        holder.tbaokuan_xiangqing = (TextView) convertView.findViewById(R.id.tbaokuan_xiangqing);

        holder.tbaokuan_shijia= (TextView) convertView.findViewById(R.id.tbaokuan_tv_shijia);

        holder.tbaokuan_yuanjia= (TextView) convertView.findViewById(R.id.tbaokuan_tv_yuanjia);

        holder.mCardView = convertView.findViewById(R.id.cardView_tbaokuan);
        holder.mCardView.setRadius(30);
        holder.mCardView.setCardElevation(8);


        if(baokuanBean.getImageUrl()!=null){
            Picasso.with(context).load(baokuanBean.getImageUrl()).into(holder.tbaokuan_img);
        }
        holder.tbaokuan_title.setText(mBaokuanBeenlist.get(position).getTuijian_title());
        holder.tbaokuan_xiangqing.setText(mBaokuanBeenlist.get(position).getTuijian_xiangqing());
        holder.tbaokuan_yuanjia.setText(mBaokuanBeenlist.get(position).getTuijian_yuanjia());
        /*划线*/
        holder.tbaokuan_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        /*抗锯齿*/
        holder.tbaokuan_yuanjia.getPaint().setAntiAlias(true);
        holder.tbaokuan_shijia.setText(mBaokuanBeenlist.get(position).getTuijian_shijia());

        return convertView;
    }

    public class GridViewHolder{
        ImageView tbaokuan_img;
        ImageView car_tbaokuan_img;
        TextView tbaokuan_shijia;
        TextView tbaokuan_yuanjia;
        TextView tbaokuan_title;
        TextView tbaokuan_xiangqing;
        CardView mCardView;
    }
}
