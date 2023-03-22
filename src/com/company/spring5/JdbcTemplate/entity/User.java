package com.company.spring5.JdbcTemplate.entity;/**
 * @author haifeng.zeng
 * @date 2023/2/9
 * @time 12:19
 * @package_name com.company.spring5.JdbcTemplate.entity
 * @project_name spring5FrameWork
 */

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/2/9
 */
public class User {

    private String userCode;
    private String userName;
    private String company;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
