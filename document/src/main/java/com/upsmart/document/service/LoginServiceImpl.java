package com.upsmart.document.service;

import java.util.Map;

import com.upsmart.document.converter.UserConverter;
import com.upsmart.document.domain.User;
import com.upsmart.document.repository.UserRepository;
import com.upsmart.document.util.Md5;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author upsmart
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConvertor;

    /**
     * @param map
     * @return
     */
    public String login(Map<String, Object> map) {
        String result = "用户名或密码错误";
        String uname = (String) map.get("uname");
        String upassword = (String) map.get("upassword");
        User user = this.userRepository.findByUname(uname);
        if (null != user) {
//            System.out.println(Md5.MD5(upassword));
            if (user.getUpwd().equals(Md5.MD5(upassword))) {
                if (user.getVerify()) {
                    result = "1";
                } else {
                    result = "0";
                }
            }
        }
        return result;
    }

    /**
     * @param map
     * @return
     */
    public int chPwd(Map<String, Object> map) {
        int result = 0;
        String uname = (String) map.get("user");
        String upassword = (String) map.get("old");
        String newpassword = (String) map.get("_new");
        User user = this.userRepository.findByUname(uname);
        if (null != user) {
            if (!user.getUpwd().equals(Md5.MD5(upassword))) {
                result = 0;
                //"原始密码不正确";
            } else {
                user.setUpwd(Md5.MD5(newpassword));
                this.userRepository.save(user);
                result = 1;
                //"修改成功";
            }
        }
        return result;
    }
}
