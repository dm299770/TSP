package com.xxx.demo.controller.login;

import com.alibaba.fastjson.JSONObject;
import com.xxx.demo.dto.sys.UserInfo;
import com.xxx.demo.frame.annotation.CurrentUser;
import com.xxx.demo.frame.annotation.LoginRequired;
import com.xxx.demo.frame.constants.AppResultConstants;
import com.xxx.demo.services.login.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:登录
 * @author:@leo.
 */
@RestController
@RequestMapping({"/logout"})
public class LogoutController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoginService loginService;

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "logout")
    public Object logout(@CurrentUser UserInfo user) {
        JSONObject result = new JSONObject();
        if(user == null) {
            result.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
            result.put(AppResultConstants.MSG, AppResultConstants.LOGOUT_ERROR);
        }else{
            result = loginService.logout(user.getPhoneNum());
        }
        return result;
    }
}
