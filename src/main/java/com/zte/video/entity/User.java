package com.zte.video.entity;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-25 9:07
 * Description:<描述>
 */
public class User implements Serializable{

    private Integer id;

    private String pwd;

    private String name;

    private String registDate;

    private Integer powerID;

    public User(){
    }


    public User(Integer id,String name,String registDate,Integer powerID){
        this.id=id;
        this.name=name;
        this.registDate=registDate;
        this.powerID=powerID;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
