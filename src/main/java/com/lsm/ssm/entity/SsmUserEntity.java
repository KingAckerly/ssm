package com.lsm.ssm.entity;


public class SsmUserEntity {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public SsmUserEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SsmUserEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "SsmUserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
