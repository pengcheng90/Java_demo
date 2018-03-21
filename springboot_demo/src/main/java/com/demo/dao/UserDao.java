package com.demo.dao;

import com.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xiebaobiao
 * Date: 2018/3/21
 * Time: 15:26
 * Description:
 */
public interface UserDao {

    List<User> findAllUser();

    User findById(@Param("id") Long id);

    Long saveUser(User city);

    Long updateUser(User city);

    Long deleteUser(Long id);

    User findByUserNameAndPasss(@Param("username") String username, @Param("password")String password);
}