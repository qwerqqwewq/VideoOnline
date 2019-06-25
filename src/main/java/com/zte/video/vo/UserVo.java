package com.zte.video.vo;

/**
 * Author:helloboy
 * Date:2019-06-24 17:36
 * Description:<描述>
 */
public class UserVo {
    private Integer id;

    private String pwd;

    private String name;

    private String registDate;

    private Integer powerID;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public Integer getPowerID() {
        return powerID;
    }

    public void setPowerID(Integer powerID) {
        this.powerID = powerID;
    }



}
