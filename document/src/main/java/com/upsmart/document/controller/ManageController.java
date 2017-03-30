package com.upsmart.document.controller;

import com.upsmart.document.msg.BaseMessage;
import com.upsmart.document.msg.StatusCode;
import com.upsmart.document.service.ManageService;
import com.upsmart.document.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    private static Logger logger = LoggerFactory.getLogger(ManageController.class);

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
        String seo="";
        String user=map.get("user").toString();
        if(map.containsKey("seo")){seo=map.get("seo").toString();};
        try {
            if(seo==null||seo.equals("")){
                List<Map<String, Object>> result=this.manageService.docFindByOwner(user);
                msg.setData(result);
            }else{
                List<Map<String, Object>> result=this.manageService.docFindByOwner(user,seo);
                msg.setData(result);
            }
        } catch (Exception e) {
            ResponseUtil.buildResMsg(msg, StatusCode.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return msg;
    }
    // 新增doc，并在doc表添加目录
    @RequestMapping(value = "upLoadDoc", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage upLoadDoc(HttpServletRequest request,
                                 @RequestParam("s") String s,
                                 @RequestParam(value = "file", required = false) MultipartFile[] files) {
        BaseMessage msg = new BaseMessage();
        try {
            // 写入
            String path = request.getSession().getServletContext().getRealPath("/file/doc/");
            String result = this.manageService.upLoadDoc(path, s, files);
            if(!result.equals("")){
                ResponseUtil.buildResMsg(msg, StatusCode.DATA_ERROR);
                msg.setData(result);
            }else{
                ResponseUtil.buildResMsg(msg, StatusCode.SUCCESS);
                msg.setData(result);
            }
        } catch (Exception e) {
            logger.error("上传文件失败");
            msg.setData("系统出错");
            ResponseUtil.buildResMsg(msg,StatusCode.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return msg;
    }
    /*
    *
    * */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public  BaseMessage delete(@RequestBody  Map<String, Object> map){
        BaseMessage msg = new BaseMessage();
        String owner=map.get("user").toString();
        List<Integer> id= (List<Integer>) map.get("id");
        String result=manageService.deleteDoc(owner,id);
        msg.setMsg(result);
        return msg;

    }

    @RequestMapping(value = "chDiscription",method = RequestMethod.POST)
    @ResponseBody
    public  BaseMessage chDiscription(@RequestBody  Map<String, Object> map){
        BaseMessage msg = new BaseMessage();
        String owner=map.get("user").toString();
        Integer id= (Integer) map.get("id");
        String change= map.get("change").toString();
        String result=manageService.chDocDiscription( owner, id, change);
        msg.setMsg(result);
        return msg;

    }
    @RequestMapping(value = "showBooks",method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage showBooks(@RequestBody  Map<String, Object> map){
        BaseMessage msg = new BaseMessage();
        String seo="";String seoType="";
        String user=map.get("user").toString();
        if(map.containsKey("seo")){
            seo=map.get("seo").toString();
            seoType=map.get("seoType").toString();};
        try {
            if(seo==null||seo.equals("")){
                List<Map<String, Object>> result=this.manageService.bookFindByOwner(user);
                msg.setData(result);
            }else{
                List<Map<String, Object>> result=this.manageService.bookFindByOwner(user,seo,seoType);
                msg.setData(result);
            }
        } catch (Exception e) {
            ResponseUtil.buildResMsg(msg, StatusCode.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return msg;
    }
    @RequestMapping(value = "upLoadBook",method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage upLoadBook(HttpServletRequest request,
                                  @RequestParam("s") String s,
                                  @RequestParam(value = "file", required = false) MultipartFile[] files){
        BaseMessage msg = new BaseMessage();
        try {
            // 写入
            String path = request.getSession().getServletContext().getRealPath("/file/book/");
            String result = this.manageService.upLoadBook(path, s, files);
            if(!result.equals("")){
                ResponseUtil.buildResMsg(msg, StatusCode.DATA_ERROR);
                msg.setData(result);
            }else{
                ResponseUtil.buildResMsg(msg, StatusCode.SUCCESS);
                msg.setData(result);
            }
        } catch (Exception e) {
            logger.error("上传文件失败");
            msg.setData("系统出错");
            ResponseUtil.buildResMsg(msg,StatusCode.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return msg;
    }
    @RequestMapping(value = "deleteBook",method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage deleteBook(@RequestBody  Map<String, Object> map){
        BaseMessage msg = new BaseMessage();
        String owner=map.get("user").toString();
        List<Integer> id= (List<Integer>) map.get("id");
        String result=manageService.deleteBook(owner,id);
        msg.setMsg(result);
        return msg;
    }

    @RequestMapping(value = "chBookDiscription",method = RequestMethod.POST)
    @ResponseBody
    public  BaseMessage chBookDiscription(@RequestBody  Map<String, Object> map){
        BaseMessage msg = new BaseMessage();
        String owner=map.get("user").toString();
        Integer id= (Integer) map.get("id");
        String change= map.get("change").toString();
        String result=manageService.chBookDiscription( owner, id, change);
        msg.setMsg(result);
        return msg;

    }

    @RequestMapping(value = "addLabel",method = RequestMethod.POST)
    @ResponseBody
    public  BaseMessage addLabel(@RequestBody  Map<String, Object> map){
        BaseMessage msg = new BaseMessage();
        String owner=map.get("user").toString();
        Integer id= (Integer) map.get("id");
        String change= map.get("change").toString();
        String result=manageService.chBookDiscription( owner, id, change);
        msg.setMsg(result);
        return msg;

    }
    @RequestMapping(value = "otherSearch",method = RequestMethod.POST)
    @ResponseBody
    public  BaseMessage otherSearch(@RequestBody  Map<String, Object> map){
        BaseMessage msg = new BaseMessage();
        String index="";
        String user=map.get("user").toString();
        index=map.get("index").toString();
        String value=map.get("value").toString();
        try {
            msg.setData(this.manageService.otherSearch(user,value,index));
            msg.setMsg("");

        } catch (Exception e) {
            ResponseUtil.buildResMsg(msg, StatusCode.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return msg;

    }

}
