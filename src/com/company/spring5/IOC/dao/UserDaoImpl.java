package com.company.spring5.IOC.dao;
/**
 * @author haifeng.zeng
 * @date 2023/1/9
 * @time 12:23
 * @package_name com.company.spring5.IOC.dao
 * @project_name spring5FrameWork
 */

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/9
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void update() {
        System.out.println("dao update.......");
    }
}
