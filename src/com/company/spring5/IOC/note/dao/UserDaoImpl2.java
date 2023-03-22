package com.company.spring5.IOC.note.dao;/**
 * @author haifeng.zeng
 * @date 2023/1/17
 * @time 9:33
 * @package_name com.company.spring5.IOC.note.dao
 * @project_name spring5FrameWork
 */

import org.springframework.stereotype.Repository;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/17
 */
@Repository(value = "userDaoImpl2")
public class UserDaoImpl2 implements UserDao{
    @Override
    public void add() {
        System.out.println("UserDao add2............");
    }
}
