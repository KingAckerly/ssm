package com.lsm.ssm.entity;


public class UserInfoEntity {
    private Integer id;
    private Integer userId;
    private String account;

    public Integer getId() {
        return id;
    }

    public UserInfoEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public UserInfoEntity setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public UserInfoEntity setAccount(String account) {
        this.account = account;
        return this;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", account='" + account + '\'' +
                '}';
    }
}
