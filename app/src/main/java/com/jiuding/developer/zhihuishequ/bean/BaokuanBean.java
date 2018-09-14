package com.jiuding.developer.zhihuishequ.bean;

/**
 * Created by macbookair on 2017/9/27.
 */

public class BaokuanBean {

    /*TextView tuijian_shijia;
        TextView tuijian_yuanjia;
        TextView tuijian_title;
        TextView tuijian_xiangqing;*/
    private String tuijian_shijia;
    private String tuijian_yuanjia;
    private String tuijian_xiangqing;
    private String imageUrl;
    private String tuijian_title;

    public BaokuanBean(String imageUrl , String tuijian_title, String tuijian_xiangqing, String tuijian_yuanjia, String tuijian_shijia){
        this.imageUrl = imageUrl;
        this.tuijian_title = tuijian_title;
        this.tuijian_xiangqing = tuijian_xiangqing;
        this.tuijian_yuanjia = tuijian_yuanjia;
        this.tuijian_shijia = tuijian_shijia;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTuijian_title(String tuijian_title) {
        this.tuijian_title = tuijian_title;
    }

    public String getTuijian_title() {
        return tuijian_title;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public String getTuijian_shijia() {
        return tuijian_shijia;
    }

    public void setTuijian_shijia(String tuijian_shijia) {
        this.tuijian_shijia = tuijian_shijia;
    }

    public String getTuijian_yuanjia() {
        return tuijian_yuanjia;
    }

    public void setTuijian_yuanjia(String tuijian_yuanjia) {
        this.tuijian_yuanjia = tuijian_yuanjia;
    }

    public String getTuijian_xiangqing() {
        return tuijian_xiangqing;
    }

    public void setTuijian_xiangqing(String tuijian_xiangqing) {
        this.tuijian_xiangqing = tuijian_xiangqing;
    }

}
