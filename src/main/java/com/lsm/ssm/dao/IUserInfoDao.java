package com.lsm.ssm.dao;


import com.lsm.ssm.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserInfoDao {
    int saveBatchUserInfo(@Param("list") List<UserInfoEntity> userInfoEntityList);
}
