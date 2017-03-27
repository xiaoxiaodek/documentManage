package com.upsmart.document.service;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author upsmart
 */
@Service
public interface LoginService {
    /**
     *
     * @param map
     * @return
     */
    String login(Map<String, Object> map);
    /**
     *
     * @param map
     * @return
     */
    int chPwd(Map<String, Object> map);
}
