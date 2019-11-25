package com.lsm.ssm.service;


import com.lsm.ssm.entity.UserEntity;

import java.util.List;

public interface IUserService {

    List<UserEntity> listUser();

    int saveBatch();

    void testOracle();

    void testJDBCPagingQuery(Integer pageSizes, Integer page);

}
