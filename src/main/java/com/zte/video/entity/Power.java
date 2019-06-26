package com.zte.video.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author:helloboy
 * @Date:2019-06-25 9:13
 * Description:<描述>
 */
public class Power implements Serializable{
    private Integer id;

    private Set<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    private String power;

    public Power(Integer id,String power){
        this.id=id;
        this.power=power;
    }

    public Power(){
    }

    @Override
    public String toString() {
        return "Power{" +
                "id=" + id +
                ", power='" + power + '\'' +
                '}';
    }
}
