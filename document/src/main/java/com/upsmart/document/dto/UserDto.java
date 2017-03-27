package com.upsmart.document.dto;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @since 17-3-16
 */
public class UserDto {
    private int uid;

    private String uname;

    /**
     *
     * @return
     */
    public int getUid() {
        return uid;
    }

    /**
     *
     * @param uid
     */
    public void setUid(int uid) {
        this.uid = uid;
    }

    /**
     *
     * @return
     */
    public String getUname() {
        return uname;
    }

    /**
     *
     * @param uname
     */
    public void setUname(String uname) {
        this.uname = uname;
    }
}
