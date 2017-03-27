package com.upsmart.document.controller;

import com.upsmart.document.msg.BaseMessage;
import com.upsmart.document.msg.StatusCode;
import com.upsmart.document.service.ManageService;
import com.upsmart.document.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @since 17-3-21
 */
@Controller
@RequestMapping(value="manage")
public class ManageController {

    @Autowired private ManageService manageService;

    /**
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "show",method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage show(@RequestBody  Map<String, Object> map){
        BaseMessage msg = new BaseMessage();
        String user=map.get("user").toString();
        try {
            List<Map<String, Object>> result=this.manageService.findByOwner(user);
            msg.setData(result);

        } catch (Exception e) {
            ResponseUtil.buildResMsg(msg, StatusCode.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return msg;
    }
    @RequestMapping(value = "show2",method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage upLoad(@RequestBody  Map<String, Object> map){
        BaseMessage msg = new BaseMessage();
        String user=map.get("user").toString();
        try {
            List<Map<String, Object>> result=this.manageService.findByOwner(user);
            msg.setData(result);

        } catch (Exception e) {
            ResponseUtil.buildResMsg(msg, StatusCode.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return msg;
    }
}
