package com.uhackathon.momo.model;

public class UserInfo {

    private String nicname;
    private String sex;
    private int age;
    private String disabled;
    private String disabledType;

    public UserInfo() {
    }

    public UserInfo(String nicname, String sex, int age, String disabled, String disabledType) {
        this.nicname = nicname;
        this.sex = sex;
        this.age = age;
        this.disabled = disabled;
        this.disabledType = disabledType;
    }

    public String getNicname() {
        return nicname;
    }

    public void setNicname(String nicname) {
        this.nicname = nicname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public String getDisabledType() {
        return disabledType;
    }

    public void setDisabledType(String disabledType) {
        this.disabledType = disabledType;
    }
}
