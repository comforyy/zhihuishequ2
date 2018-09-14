package com.jiuding.developer.zhihuishequ.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobUser;

/**
 * Created by macbookair on 2017/11/8.
 */

public class Denglu extends BmobUser implements Serializable {
    //姓名
    String Name;
    //密码
    String Password;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public void setPassword(String password) {
        Password = password;
    }
}
