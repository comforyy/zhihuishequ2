package com.jiuding.developer.zhihuishequ.bean;

import java.io.Serializable;

/**
 * Created by Ivan on 15/9/24.
 */
public class BaseBean implements Serializable {


    private static final long serialVersionUID = -4292363949374596518L;
    protected   long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
