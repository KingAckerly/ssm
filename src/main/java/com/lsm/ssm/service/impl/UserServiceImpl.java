package com.lsm.ssm.service.impl;


import com.lsm.ssm.dao.*;
import com.lsm.ssm.entity.SsmUserEntity;
import com.lsm.ssm.entity.SsmUserInfoEntity;
import com.lsm.ssm.entity.UserEntity;
import com.lsm.ssm.entity.UserInfoEntity;
import com.lsm.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private IUserInfoDao userInfoDao;
    @Autowired
    private ISsmUserDao ssmUserDao;
    @Autowired
    private ISsmUserInfoDao ssmUserInfoDao;


    @Override
    public List<UserEntity> listUser() {
        return userDao.listUser();
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    @Override
    public int saveBatch() {
        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(new UserEntity().setName("王五"));
        userEntityList.add(new UserEntity().setName("赵六"));
        userDao.saveBatchUser(userEntityList);
        List<UserInfoEntity> userInfoEntityList = new ArrayList<>();
        userInfoEntityList.add(new UserInfoEntity().setUserId(10).setAccount("100"));
        userInfoEntityList.add(new UserInfoEntity().setUserId(20).setAccount("200"));
        userInfoDao.saveBatchUserInfo(userInfoEntityList);
        return 0;
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    @Override
    public void testOracle() {
        String uuid = UUID.randomUUID().toString();
        SsmUserEntity ssmUserEntity1 = new SsmUserEntity().setId(uuid).setName("王五");
        ssmUserDao.saveSsmUser(ssmUserEntity1);
        SsmUserInfoEntity ssmUserInfoEntity1 = new SsmUserInfoEntity().setUserId(uuid).setAccount("100");
        ssmUserInfoDao.saveSsmUserInfo(ssmUserInfoEntity1);
    }

    @Override
    public void testJDBCPagingQuery(Integer pageSizes, Integer page) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:test", "SSM", "lsm.951207");
            String sql = "SELECT COUNT(1) FROM SSM_TEST";
            StringBuffer sb = new StringBuffer();
            sb.append(" SELECT ");
            sb.append(" * ");
            sb.append(" FROM ");
            sb.append(" ( ");
            sb.append(" SELECT ");
            sb.append(" ROWNUM AS rowno, ");
            sb.append(" T .* ");
            sb.append(" FROM ");
            sb.append(" SSM_TEST T ");
            sb.append(" WHERE ");
            sb.append(" ROWNUM <= ? ");
            sb.append(" ) table_alias ");
            sb.append(" WHERE ");
            sb.append(" table_alias.rowno > ? ");
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            //最大页码
            int maxPage;
            //总条数
            Integer total = resultSet.getInt(1);
            if (total % pageSizes == 0) {
                maxPage = total / pageSizes;
            } else {
                maxPage = total / pageSizes + 1;
            }
            if (page > maxPage) {
                page = maxPage;
            }
            ps = connection.prepareStatement(sb.toString());
            int start = pageSizes * page;
            int end = pageSizes * page - pageSizes;
            ps.setInt(1, start);
            ps.setInt(2, end);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Integer rowno = resultSet.getInt(1);
                Integer id = resultSet.getInt(2);
                String name = resultSet.getString(3);
                System.out.println(rowno);
                System.out.println(id);
                System.out.println(name);
            }
            resultSet.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
