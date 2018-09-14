package com.jiuding.developer.zhihuishequ.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiuding.developer.zhihuishequ.R;
import com.jiuding.developer.zhihuishequ.bean.TuiJianBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Tom on 2017/8/28.
 */

public class TuiJianAdapter extends BaseAdapter {

    CardView mCardView;
    private Context context;

    private View.OnClickListener mOnClickListener;


    private ArrayList<TuiJianBean> tuijianlist;
    public TuiJianAdapter(Context context, ArrayList<TuiJianBean> tuijianlist){
        this.context = context;
        this.tuijianlist = tuijianlist;
    }
    @Override
    public int getCount() {
        return tuijianlist.size();
    }

    @Override
    public Object getItem(int position) {
        return tuijianlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        GridViewHolder holder = null;
        TuiJianBean tuiJianBean = tuijianlist.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.time_limit_item,parent,false);
        holder =new GridViewHolder();
        convertView.setTag(holder);
        holder.tuijian_img= (ImageView) convertView.findViewById(R.id.tuijain_img);

        holder.car_img = convertView.findViewById(R.id.car_imag);

        holder.car_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemDeleteListener.onDeleteClick(position);
            }
        });


        holder.tuijian_title = (TextView) convertView.findViewById(R.id.tuijian_title);

        holder.tuijian_xiangqing = (TextView) convertView.findViewById(R.id.tuijian_xiangqing);

        holder.tuijian_shijia= (TextView) convertView.findViewById(R.id.tuijian_tv_shijia);

        holder.tuijian_yuanjia= (TextView) convertView.findViewById(R.id.tuijian_tv_yuanjia);

        holder.mCardView = convertView.findViewById(R.id.cardView_tuijian);
        holder.mCardView.setRadius(30);
        holder.mCardView.setCardElevation(8);


        if(tuiJianBean.getImageUrl()!=null){
            Picasso.with(context).load(tuiJianBean.getImageUrl()).into(holder.tuijian_img);
        }
        holder.tuijian_title.setText(tuijianlist.get(position).getTuijian_title());
        holder.tuijian_xiangqing.setText(tuijianlist.get(position).getTuijian_xiangqing());
        holder.tuijian_yuanjia.setText(tuijianlist.get(position).getTuijian_yuanjia());
        /*划线*/
        holder.tuijian_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        /*抗锯齿*/
        holder.tuijian_yuanjia.getPaint().setAntiAlias(true);
        holder.tuijian_shijia.setText(tuijianlist.get(position).getTuijian_shijia());

        return convertView;
    }

    public interface onItemDeleteListener {
        void onDeleteClick(int position);
    }

    private onItemDeleteListener mOnItemDeleteListener;

    public void setOnItemDeleteClickListener(onItemDeleteListener mOnItemDeleteListener) {
        this.mOnItemDeleteListener = mOnItemDeleteListener;
    }

    public class GridViewHolder{
        ImageView tuijian_img;
        ImageView car_img;
        TextView tuijian_shijia;
        TextView tuijian_yuanjia;
        TextView tuijian_title;
        TextView tuijian_xiangqing;
        CardView mCardView;
    }

}
