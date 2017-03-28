package com.upsmart.document.msg;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @version 0.0.1
 */
public enum StatusCode {

    // success
    SUCCESS("00000", "提交成功"),
    NO_RESPONSE("00001", "没有查询到结果"),
    // fail
    ACCOUNT_PWD_INVALID_NOT_EXISTS("10110", "账号名密码不匹配"),
    ACCOUNT_INVALID_NOT_EXISTS("10104", "账号不存在"),
    VERIFICATION_CODE_ERROR("00002","验证码出错"),
    PWD_CONFIRM("00003","密码输入不一致"),
    ERROR("00004", "操作出错,"),
    ERROR_PREPWD("00006","原始密码出错"),
    SYSTEM_ERROR("20101", "系统异常"),
    ERROR_INPUT("00005","INPUT ERROR"),
    DATA_ERROR("00007","数据出错");
    private String code;
    private String msg;

    /**
     *
     * @param code 状态码
     * @param msg 说明内容
     */
    StatusCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @return msg
     */
    public String getMsg() {
        return msg;
    }
    
}
