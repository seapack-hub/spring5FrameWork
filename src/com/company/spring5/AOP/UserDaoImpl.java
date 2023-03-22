package com.company.spring5.AOP;/**
 * @author haifeng.zeng
 * @date 2023/2/3
 * @time 12:22
 * @package_name com.company.spring5.AOP
 * @project_name spring5FrameWork
 */

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/2/3
 */
public class UserDaoImpl implements UserDao{
    @Override
    public int add(int a,int b) {
        return a + b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
