package com.jiuding.developer.zhihuishequ.adapter;

import android.content.Context;
import android.net.Uri;
import android.widget.CheckBox;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jiuding.developer.zhihuishequ.R;
import com.jiuding.developer.zhihuishequ.bean.ShoppingCart;

import java.util.List;


/**
 * Created by macbookair on 2017/10/12.
 */

public class CartAdapter extends SimpleAdapter<ShoppingCart>{

    public static final String TAG="CartAdapter";

    public CartAdapter(Context context, List<ShoppingCart> datas, CheckBox checkBox, TextView textTotal) {
        super(context, R.layout.template_cart, datas);
    }

    public CartAdapter(Context context, int layoutResId, List<ShoppingCart> datas) {
        super(context, layoutResId, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, final ShoppingCart item) {

        viewHoder.getTextView(R.id.text_title).setText(item.getName());
        viewHoder.getTextView(R.id.text_price).setText("Y"+item.getPrice());
        SimpleDraweeView draweeView = (SimpleDraweeView) viewHoder.getView(R.id.drawee_view);
        draweeView.setImageURI(Uri.parse(item.getImgUrl()));

        CheckBox checkBox = (CheckBox) viewHoder.getView(R.id.checkbox);
        checkBox.setChecked(item.isChecked());

    }
}
