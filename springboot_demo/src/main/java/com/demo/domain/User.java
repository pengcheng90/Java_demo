package com.demo.domain;

/**
 * Created with IntelliJ IDEA.
 * User:
 * Date: 2018/3/21
 * Time: 15:21
 * Description:用户实体
 */
public class User {

    private Long id;

    private String username;

    private String password;

    private String updatetime;

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

