package com.company.spring5.JdbcTemplate.Dao;/**
 * @author haifeng.zeng
 * @date 2023/2/8
 * @time 20:18
 * @package_name com.company.spring5.JdbcTemplate.Dao
 * @project_name spring5FrameWork
 */

import com.company.spring5.JdbcTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/2/8
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney() {

    }

    @Override
    public void addUser(User user) {
        //创建sql语句
        String sql = "insert into user_test(userCode,userName,company) values(?,?,?)";
        //调用实现方法
        Object[] args = {user.getUserCode(),user.getUserName(),user.getCompany()};
        int index = jdbcTemplate.update(sql,args);
        System.out.println(index);
    }

    @Override
    public void updateUser(User user) {
        //创建sql语句
        String sql = "update user_test set userName = ?,company = ? where userCode=?";
        //调用实现方法
        Object[] args = {user.getUserName(),user.getCompany(),user.getUserCode(),};
        int index = jdbcTemplate.update(sql,args);
        System.out.println(index);
    }

    @Override
    public void deleteUser(String userCode) {
        String sql = "delete from user_test where userCode=?";
        //调用实现方法
        int index = jdbcTemplate.update(sql,userCode);
        System.out.println(index);
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from user_test";
        return jdbcTemplate.queryForObject(sql,int.class);
    }


}
