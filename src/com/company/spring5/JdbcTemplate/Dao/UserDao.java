package com.company.spring5.JdbcTemplate.Dao;/**
 * @author haifeng.zeng
 * @date 2023/2/8
 * @time 20:07
 * @package_name com.company.spring5.JdbcTemplate.Dao
 * @project_name spring5FrameWork
 */

import com.company.spring5.JdbcTemplate.entity.User;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/2/8
 */
public interface UserDao {
    public void addMoney();

    //新增
    public void addUser(User user);

    //修改
    public void updateUser(User user);

    //删除
    public void deleteUser(String userCode);

    public int selectCount();
}
