package com.company.spring5.IOC;
/**
 * @author haifeng.zeng
 * @date 2023/1/6
 * @time 8:49
 * @package_name com.company.spring5
 * @project_name spring5FrameWork
 */

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/6
 */
public class User {

    private String userName;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public void add(){
        System.out.println("add.....");
    }
}
