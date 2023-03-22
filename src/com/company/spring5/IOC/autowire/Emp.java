package com.company.spring5.IOC.autowire;/**
 * @author haifeng.zeng
 * @date 2023/1/12
 * @time 15:42
 * @package_name com.company.spring5.autowrite
 * @project_name spring5FrameWork
 */

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/12
 */
public class Emp {

    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }

    public void test(){
        System.out.println("emp........");
    }
}
