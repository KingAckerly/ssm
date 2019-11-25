package com.lsm.ssm.dao;

import com.lsm.ssm.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface IUserDao {
    List<UserEntity> listUser();

    int saveBatchUser(@Param("list") List<UserEntity> userEntityList);
}
