package com.chrzha.entity;

import javax.persistence.*;

/**
 * Created by Chris Zhang on 2017/6/18.
 */

@Entity(name="user")
public class User {

    public User(){
        super();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="username",length=32)
    private String userName;

    @Column(name="age")
    private Integer age;

    @Column(name="nicename",length=32)
    private String niceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }
}