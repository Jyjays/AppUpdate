package com.appup.domain;

public class User {
    private int id;
    private String school;
    private String account;
    private String method;

    public User() {
    }

    public User(int id, String school, String account, String method) {
        this.id = id;
        this.school = school;
        this.account = account;
        this.method = method;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return school
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置
     * @param school
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 获取
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置
     * @param method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    public String toString() {
        return "User{id = " + id + ", school = " + school + ", account = " + account + ", method = " + method + "}";
    }
}
