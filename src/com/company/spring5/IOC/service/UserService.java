package com.company.spring5.IOC.service;/**
 * @author haifeng.zeng
 * @date 2023/1/9
 * @time 12:20
 * @package_name com.company.spring5.IOC.service
 * @project_name spring5FrameWork
 */

import com.company.spring5.IOC.note.dao.UserDaoImpl;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/9
 */
public class UserService {

    //创建UserDao类型属性，生成set方法
    private UserDaoImpl userDao;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("add...........");

        //原始调用方式:创建对象
        //UserDao userDao = new UserDaoImpl();
        //userDao.update();
//        userDao.update();
    }
}
