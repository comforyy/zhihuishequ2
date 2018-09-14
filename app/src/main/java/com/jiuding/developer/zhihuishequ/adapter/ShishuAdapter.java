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
import com.jiuding.developer.zhihuishequ.bean.ShishuBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by macbookair on 2017/9/28.
 */

public class ShishuAdapter extends android.widget.BaseAdapter {

    private Context mContext;

    private ArrayList<ShishuBean>ShishuBeanList;


    public ShishuAdapter(Context mContext,ArrayList<ShishuBean>ShishuBeanList){

        this.mContext = mContext;
        this.ShishuBeanList = ShishuBeanList;

    }

    @Override
    public int getCount() {
        return ShishuBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return ShishuBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ShishuGridView holder = null;
        ShishuBean shishuBean = ShishuBeanList.get(position);
        convertView = LayoutInflater.from(mContext).inflate(R.layout.shishu_item,parent,false);
        holder = new ShishuGridView();
        convertView.setTag(holder);

        holder.shihshu_ImageUrl = convertView.findViewById(R.id.shishu_img);
        holder.shihshu_shijian = convertView.findViewById(R.id.tv_shishu_shijia);
        holder.shishu_yuanjia = convertView.findViewById(R.id.tv_shishu_yuanjia);
        holder.shishu_miaoshu = convertView.findViewById(R.id.shishu_miaoshu);
        holder.shishu_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.shishu_yuanjia.getPaint().setAntiAlias(true);

        holder.cardView_shishu = convertView.findViewById(R.id.cardView_shishu);

        holder.cardView_shishu.setRadius(30);
        holder.cardView_shishu.setCardElevation(8);

        holder.shishu_car = convertView.findViewById(R.id.shishu_car);

        if (shishuBean.getShihshu_ImageUrl() != null){

            Picasso.with(mContext).load(shishuBean.getShihshu_ImageUrl()).into(holder.shihshu_ImageUrl);

        }

        holder.shishu_miaoshu.setText(ShishuBeanList.get(position).getShishu_miaoshu());
        holder.shihshu_shijian.setText(ShishuBeanList.get(position).getShihshu_shijian());
        holder.shishu_yuanjia.setText(ShishuBeanList.get(position).getShishu_yuanjia());

        holder.shishu_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetOnCarListener.setOnCarListener(position);
            }
        });

        return convertView;
    }

    private interface setOnCarListener{
        void setOnCarListener(int position);
    }
    private setOnCarListener SetOnCarListener;

    private void setSetOnCarListener(setOnCarListener setOnClickCarListener){
        this.SetOnCarListener = setOnClickCarListener;
    }

    class ShishuGridView{

        private ImageView shihshu_ImageUrl;
        private ImageView shishu_car;
        private TextView shishu_miaoshu;
        private TextView shihshu_shijian;
        private TextView shishu_yuanjia;
        private CardView cardView_shishu;

    }
}
