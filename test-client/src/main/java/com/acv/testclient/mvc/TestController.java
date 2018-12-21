package com.acv.testclient.mvc;

import com.acv.testclient.ACV_UA.model.UserInfo;
import com.acv.testclient.feign.ACV_UA_Feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    ACV_UA_Feign fegin;

    @GetMapping("/test")
    @ResponseBody
    public Object test(){
        //Object object = fegin.login("18101671990","21232f297a57a5a743894a0e4a801fc3","181ABCDEFG");
        Object object = fegin.getUserInfo(new UserInfo());
        return object;
    }


}
