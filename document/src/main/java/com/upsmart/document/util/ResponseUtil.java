package com.upsmart.document.util;


import com.upsmart.document.constant.GlobalConstants;
import com.upsmart.document.msg.BaseMessage;
import com.upsmart.document.msg.StatusCode;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author qianjc
 * @version 0.0.1
 */
public class ResponseUtil {

    public static boolean IS_SIGN = true;

    /**
     * 构造返回message
     * 
     * @param msg
     * @param sta
     */
    public static void buildResMsg(BaseMessage msg, StatusCode sta) {
        if (null != msg) {
            msg.setCode(sta.getCode());
            msg.setMsg(sta.getMsg());
        }
    }

    /**
     * 构造返回message
     *
     * @param msg
     * @param sta
     * @param appendMessage
     */
    public static void buildResMsg(BaseMessage msg, StatusCode sta, String appendMessage) {
        if (null != msg) {
            msg.setCode(sta.getCode());
            msg.setMsg(sta.getMsg() + GlobalConstants.COMMA + appendMessage);
        }
    }

    /**
     *
     * 通过code获取制定枚举
     *
     * @param code
     * @return
     */
    public static StatusCode getStatusCode(String code) {
        StatusCode[] statusCodes = StatusCode.values();
        for (StatusCode status : statusCodes) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }
}
