package com.jiuding.developer.zhihuishequ.bean;

/**
 * Created by macbookair on 2017/9/28.
 */

public class ShishuBean {

    private String shihshu_ImageUrl;
    private String shishu_miaoshu;
    private String shihshu_shijian;
    private String shishu_yuanjia;


    public ShishuBean(String shihshu_ImageUrl,String shishu_miaoshu,String shihshu_shijian,String shishu_yuanjia){
        this.shihshu_ImageUrl = shihshu_ImageUrl;
        this.shishu_miaoshu = shishu_miaoshu;
        this.shihshu_shijian = shihshu_shijian;
        this.shishu_yuanjia = shishu_yuanjia;
    }

    public String getShihshu_ImageUrl() {
        return shihshu_ImageUrl;
    }

    public void setShihshu_ImageUrl(String shihshu_ImageUrl) {
        this.shihshu_ImageUrl = shihshu_ImageUrl;
    }

    public String getShishu_miaoshu() {
        return shishu_miaoshu;
    }

    public void setShishu_miaoshu(String shishu_miaoshu) {
        this.shishu_miaoshu = shishu_miaoshu;
    }

    public String getShihshu_shijian() {
        return shihshu_shijian;
    }

    public void setShihshu_shijian(String shihshu_shijian) {
        this.shihshu_shijian = shihshu_shijian;
    }

    public String getShishu_yuanjia() {
        return shishu_yuanjia;
    }

    public void setShishu_yuanjia(String shishu_yuanjia) {
        this.shishu_yuanjia = shishu_yuanjia;
    }
}
