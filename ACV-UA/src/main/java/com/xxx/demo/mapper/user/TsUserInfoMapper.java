package com.xxx.demo.mapper.user;

import com.xxx.demo.models.sys.TmChargeAccount;
import com.xxx.demo.models.sys.TsUser;
import com.xxx.demo.models.sys.TsUserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息
 *
 * @author leo.
 */
public interface
TsUserInfoMapper {


    /**
     * 保存用户基本信息
     *
     * @param bean 用户bean
     */
    void save(TsUserInfo bean);

    /**
     *保存用户账号信息
     * @param bean 用户账户bean
     * */
    void saveAccount(TmChargeAccount bean);

    /**
     * 更新用户基本信息(只更新一个属性)
     *
     * @param type 需要更新的属性名
     * @param value 需要更新的属性值
     */
    void updateByType(@Param("phoneNum")String phoneNum,@Param("type") String type,@Param("value")String value);

}
