package com.upsmart.document.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by upsmart on 17-3-28.
 */
public class InterceptController {
    @RequestMapping(value = "norManage")
    public String manage() {
        return "norManage";
    }
}
