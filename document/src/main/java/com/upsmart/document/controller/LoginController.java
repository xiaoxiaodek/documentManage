package com.upsmart.document.controller;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.upsmart.document.constant.GlobalConstants;
import com.upsmart.document.msg.BaseMessage;
import com.upsmart.document.msg.StatusCode;
import com.upsmart.document.service.LoginService;
import com.upsmart.document.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author upsmart
 */
@Controller
@RequestMapping(value = "login")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    /**
     * @param map
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage login(@RequestBody Map<String, Object> map) {
        BaseMessage msg = new BaseMessage();
        try {
            String result = this.loginService.login(map);
            if (result.equals("1")) {
                ResponseUtil.buildResMsg(msg, StatusCode.SUCCESS);
                msg.setData(1);
            } else if (result.equals("0")) {
                ResponseUtil.buildResMsg(msg, StatusCode.SUCCESS);
                msg.setData(0);
            } else {
                logger.error("登陆异常");
                ResponseUtil.buildResMsg(msg, StatusCode.ACCOUNT_PWD_INVALID_NOT_EXISTS);
            }
        } catch (Exception e) {
            logger.error("获取客户公司异常");
            ResponseUtil.buildResMsg(msg, StatusCode.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return msg;
    }
    //&&result.equals("0"))

    /**
     * @param map
     * @return
     */
    @RequestMapping(value = "chPwd", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage function(@RequestBody Map<String, Object> map) {
        BaseMessage msg = new BaseMessage();
        try {
            int result = this.loginService.chPwd(map);
            if (!"".equals(result)) {
                if (result == 1) {
                    ResponseUtil.buildResMsg(msg, StatusCode.SUCCESS);
                } else {
                    ResponseUtil.buildResMsg(msg, StatusCode.ERROR_PREPWD);
                }
            }
        } catch (Exception e) {
            logger.error("修改密码异常");
            ResponseUtil.buildResMsg(msg, StatusCode.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return msg;
    }
}
