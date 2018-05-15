package com.demo.domain;

import com.demo.annotation.Des;

/**
 * Created with IntelliJ IDEA.
 * User:
 * Date: 2018/3/21
 * Time: 15:21
 * Description:用户实体
 */
public class User <T>{

    @Des("id,类型Long")
    private Long id;
    @Des("username.用户名")
    private String username;
    @Des("password.密码")
    private String password;
    private String updatetime;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}

