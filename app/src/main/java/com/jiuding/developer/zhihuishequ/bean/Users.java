package com.jiuding.developer.zhihuishequ.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobUser;

/**
 * Created by macbookair on 2017/11/9.
 */

public class Users extends BmobUser implements Serializable{

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
