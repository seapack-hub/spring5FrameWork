package com.company.spring5.IOC.bean;/**
 * @author haifeng.zeng
 * @date 2023/1/9
 * @time 17:58
 * @package_name com.company.spring5.IOC.bean
 * @project_name spring5FrameWork
 */

/**
 *注释
 *  员工类
 *@author: haifeng.zeng
 *@date: 2023/1/9
 */
public class Emp {

    private String empName;
    private String gender;

    private Dept dept;

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void add(){
        System.out.println(empName+"::"+gender+"::"+dept);
    }
}
