package com.jiuding.developer.zhihuishequ.bean;

import java.io.Serializable;


public class ShoppingCart extends Wares implements Serializable {


    private static final long serialVersionUID = 1836845358168622855L;
    private int count;
    private boolean isChecked=true;



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }





}
