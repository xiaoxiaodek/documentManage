package com.upsmart.document.domain;

import javax.persistence.*;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @since 17-3-16
 */
@Entity
@Table(name = "user")
public class User {
    // 用户编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", unique = true, nullable = false)
    private int uid;

    // 用户名
    @Column(name = "uname", length = 20, nullable = false)
    private String uname;

    // 密码.
    @Column(name = "upwd", length = 32, nullable = false)
    private String upwd;

    //权限
    @Column(name = "verify",nullable = false)
    private Boolean verify;

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

    /**
     *
     * @return
     */
    public String getUpwd() {
        return upwd;
    }

    /**
     *
     * @param upwd
     */
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    /**
     *
     * @return
     */
    public Boolean getVerify() {
        return verify;
    }
    /**
     *
     * @param verify
     */
    public void setVerify(Boolean verify) {
        this.verify = verify;
    }
}
