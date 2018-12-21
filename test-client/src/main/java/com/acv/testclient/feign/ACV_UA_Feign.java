package com.acv.testclient.feign;

import com.acv.testclient.ACV_UA.model.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Component
@FeignClient(name="ACV-UA")
public interface ACV_UA_Feign {
    @ResponseBody
    @RequestMapping(value = "login/login/{phoneNum}/{password}/{deviceNo}")
    public Object login(@PathVariable("phoneNum")String phoneNum, @PathVariable("password")String password, @PathVariable("deviceNo")String deviceNo) ;

    @ResponseBody
    @RequestMapping(value = "user/getUserInfo")
    public Object getUserInfo(UserInfo user);

}
