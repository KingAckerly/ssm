package com.lsm.ssm.entity;


public class SsmUserInfoEntity {
    private String userId;
    private String account;

    public String getUserId() {
        return userId;
    }

    public SsmUserInfoEntity setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public SsmUserInfoEntity setAccount(String account) {
        this.account = account;
        return this;
    }

    @Override
    public String toString() {
        return "SsmUserInfoEntity{" +
                "userId='" + userId + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
