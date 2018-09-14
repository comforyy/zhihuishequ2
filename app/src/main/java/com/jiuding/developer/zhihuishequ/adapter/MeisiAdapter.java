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
import com.jiuding.developer.zhihuishequ.bean.MeiShiBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by macbookair on 2017/10/27.
 */

public class MeisiAdapter extends android.widget.BaseAdapter {
    CardView mCardView;
    private Context context;


    private ArrayList<MeiShiBean> mMeiShiBeanlist;
    public MeisiAdapter(Context context, ArrayList<MeiShiBean> mMeiShiBeanlist){
        this.context = context;
        this.mMeiShiBeanlist = mMeiShiBeanlist;
    }
    @Override
    public int getCount() {
        return mMeiShiBeanlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mMeiShiBeanlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GridViewHolder holder = null;
        MeiShiBean meiShiBean = mMeiShiBeanlist.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.meishi_item,parent,false);
        holder =new GridViewHolder();
        convertView.setTag(holder);
        holder.meishi_img= (ImageView) convertView.findViewById(R.id.meishi_tbaokuan_img);

        holder.car_meishi_img = convertView.findViewById(R.id.meishi_car_imag);



        holder.meishi_title = (TextView) convertView.findViewById(R.id.meishi_title);

        holder.meishi_xiangqing = (TextView) convertView.findViewById(R.id.meishi_xiangqing);

        holder.meishi_shijia= (TextView) convertView.findViewById(R.id.meishi_tv_shijia);

        holder.meishi_yuanjia= (TextView) convertView.findViewById(R.id.meishi_tv_yuanjia);

        holder.mCardView = convertView.findViewById(R.id.meishi_cardView);
        holder.mCardView.setRadius(30);
        holder.mCardView.setCardElevation(8);


        if(meiShiBean.getImageUrl()!=null){
            Picasso.with(context).load(meiShiBean.getImageUrl()).into(holder.meishi_img);
        }
        holder.meishi_title.setText(mMeiShiBeanlist.get(position).getTuijian_title());
        holder.meishi_xiangqing.setText(mMeiShiBeanlist.get(position).getTuijian_xiangqing());
        holder.meishi_yuanjia.setText(mMeiShiBeanlist.get(position).getTuijian_yuanjia());
        /*划线*/
        holder.meishi_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        /*抗锯齿*/
        holder.meishi_yuanjia.getPaint().setAntiAlias(true);
        holder.meishi_shijia.setText(mMeiShiBeanlist.get(position).getTuijian_shijia());

        return convertView;
    }

    public class GridViewHolder{
        ImageView meishi_img;
        ImageView car_meishi_img;
        TextView meishi_shijia;
        TextView meishi_yuanjia;
        TextView meishi_title;
        TextView meishi_xiangqing;
        CardView mCardView;
    }
}
