package com.company.spring5.IOC.note.service;/**
 * @author haifeng.zeng
 * @date 2023/1/16
 * @time 20:01
 * @package_name com.company.spring5.IOC.note.service
 * @project_name spring5FrameWork
 */


import com.company.spring5.IOC.note.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *注释
 * 基于注解方式实现属性注入
 *@author: haifeng.zeng
 *@date: 2023/1/16
 */
@Service
public class UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl1")
    private UserDao userDao;

    public void add(){
        System.out.println("service add.......................");
        userDao.add();
    }
}
