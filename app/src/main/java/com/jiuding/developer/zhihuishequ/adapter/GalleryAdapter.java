package com.jiuding.developer.zhihuishequ.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiuding.developer.zhihuishequ.R;

import java.util.List;

/**
 * Created by Tom on 2017/8/23.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>
{
    private LayoutInflater mInflater;
    private List<Integer> mdatas;

    public GalleryAdapter(Context context, List<Integer> datats)
    {
        mInflater = LayoutInflater.from(context);
        mdatas = datats;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View arg0)
        {
            super(arg0);
        }

        ImageView mImg;
        TextView miaoshu;
        TextView tv_miaosha_yuanjia;
        TextView tv_miaosha_shijia;
    }

    @Override
    public int getItemCount()
    {
        return mdatas.size();
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = mInflater.inflate(R.layout.miaosha_layout,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mImg = (ImageView) view
                .findViewById(R.id.miaosha_img);
        viewHolder.miaoshu = view.findViewById(R.id.miaoshu);
        viewHolder.tv_miaosha_yuanjia = (TextView) view
                .findViewById(R.id.tv_miaosha_yuanjia);
        viewHolder.tv_miaosha_shijia = (TextView) view
                .findViewById(R.id.tv_miaosha_shijia);
        return viewHolder;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i)
    {
        viewHolder.mImg.setImageResource(mdatas.get(i));
        switch (i){
            case 0:
                viewHolder.miaoshu.setText("新鲜瘦肉");
                viewHolder.tv_miaosha_yuanjia.setText("25");
                viewHolder.tv_miaosha_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                viewHolder.tv_miaosha_yuanjia.getPaint().setAntiAlias(true);
                viewHolder.tv_miaosha_shijia.setText("21");
                break;
            case 1:
                viewHolder.miaoshu.setText("新鲜菜花");
                viewHolder.tv_miaosha_yuanjia.setText("6");
                viewHolder.tv_miaosha_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                viewHolder.tv_miaosha_yuanjia.getPaint().setAntiAlias(true);
                viewHolder.tv_miaosha_shijia.setText("5.5");
                break;
            case 2:
                viewHolder.miaoshu.setText("新鲜菠菜");
                viewHolder.tv_miaosha_yuanjia.setText("5");
                viewHolder.tv_miaosha_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                viewHolder.tv_miaosha_yuanjia.getPaint().setAntiAlias(true);
                viewHolder.tv_miaosha_shijia.setText("4");
                break;
            case 3:
                viewHolder.miaoshu.setText("新鲜豌豆");
                viewHolder.tv_miaosha_yuanjia.setText("8");
                viewHolder.tv_miaosha_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                viewHolder.tv_miaosha_yuanjia.getPaint().setAntiAlias(true);
                viewHolder.tv_miaosha_shijia.setText("6.5");
                break;
            case 4:
                viewHolder.miaoshu.setText("新鲜菠菜");
                viewHolder.tv_miaosha_yuanjia.setText("6");
                viewHolder.tv_miaosha_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                viewHolder.tv_miaosha_yuanjia.getPaint().setAntiAlias(true);
                viewHolder.tv_miaosha_shijia.setText("1");
                break;
        }
    }

}

