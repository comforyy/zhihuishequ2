package com.jiuding.developer.zhihuishequ.adapter.stopcar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiuding.developer.zhihuishequ.R;

/**
 * @Description:gridview的Adapter
 * @author http://blog.csdn.net/finddreams
 */
public class StopCarGridAdapter extends BaseAdapter {
	private Context mContext;

	public String[] img_text = { "绑定车牌", "停车信息", "月卡续费", "商户返利", "车位预定", "一件挪车"};
	public int[] imgs = { R.mipmap.app_transfer, R.mipmap.app_fund,
			R.mipmap.app_phonecharge, R.mipmap.app_creditcard,
			R.mipmap.app_movie, R.mipmap.app_lottery};

	public StopCarGridAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return img_text.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.stopcar_grid_item, parent, false);
		}
		TextView tv = BaseViewHolder.get(convertView, R.id.stopcar_tv_text);
		ImageView iv = BaseViewHolder.get(convertView, R.id.stopcar_tv_img);
		iv.setBackgroundResource(imgs[position]);

		tv.setText(img_text[position]);
		return convertView;
	}

}
