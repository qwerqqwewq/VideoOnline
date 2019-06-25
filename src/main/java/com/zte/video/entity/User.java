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

    private Power power;



    public User() {
    }

    public User(Integer id, String pwd, String name, String registDate, Power power) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.registDate = registDate;
        this.power = power;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", registDate='" + registDate + '\'' +
                ", power=" + power +
                '}';
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

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }
}
