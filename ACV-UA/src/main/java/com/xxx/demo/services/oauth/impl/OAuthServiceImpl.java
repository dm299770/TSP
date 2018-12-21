package com.xxx.demo.services.oauth.impl;


import com.xxx.demo.mapper.oauth.OAuthMapper;
import com.xxx.demo.models.sys.TsUser;
import com.xxx.demo.services.oauth.OAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("OAuthServiceImpl")
public class OAuthServiceImpl implements OAuthService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OAuthMapper oAuthMapper;
    
    @Override
    public void addRefreshToken(Map<String, Object> params) throws Exception{
		oAuthMapper.addRefreshToken(params);
    }
    
    @Override
    public boolean checkRefreshToken(String refreshToken) throws Exception{
    	String exp = oAuthMapper.checkRefreshToken(refreshToken);
    	if(exp == null){
    		return true;
    	}else{
    		//当前时间
        	long expireIn = System.currentTimeMillis()/1000;
    		if(expireIn > Long.parseLong(exp)){
    			return true;
    		}else{
    			return false;
    		}
    	}
    }
    
	@Override
	public void updateRefreshToken(Map<String, Object> params) throws Exception{
		oAuthMapper.updateRefreshToken(params);
	}
    
	//查询app_account_id
	@Override
	public String findAppAccountIDByRefreshToken(String refreshToken)
			throws Exception {
		return oAuthMapper.findAppAccountIDByRefreshToken(refreshToken);
	}
    
    public TsUser findByPhoneNum(String phoneNum) throws Exception{
        return oAuthMapper.findUserByPhoneNum(phoneNum);
    }

	@Override
	public Map<String, Object> checkOAuthThridparty(String client_id, String client_secret) throws Exception{
		return oAuthMapper.checkOAuthThridparty(client_id, client_secret);
	}
	
	@Override
	public void updOAuthThridpartyMes(Map<String, Object> params) throws Exception{
		oAuthMapper.updOAuthThridpartyMes(params);
	}

}
