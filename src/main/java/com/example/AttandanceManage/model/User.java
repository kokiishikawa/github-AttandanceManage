package com.example.AttandanceManage.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int id;
    private String password;
    private String name;
    private String role;
    private int division_id;

    public User(int id, String password, String name, String role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
    }
    @Override
    public String toString() {
        return "id:" + this.id + "//" + "名前" + this.name + "パスワード" + this.password;
    }
//
//    public Object getName() {
//        return getName();
//    }
//
//    public Object getPassword() {
//        return getPassword();
//    }
//
//    public Object getRole() {
//        return getRole();
//    }
}