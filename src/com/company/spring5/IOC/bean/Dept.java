package com.company.spring5.IOC.bean;/**
 * @author haifeng.zeng
 * @date 2023/1/9
 * @time 17:57
 * @package_name com.company.spring5.IOC.bean
 * @project_name spring5FrameWork
 */

/**
 *注释
 * 部门类
 *@author: haifeng.zeng
 *@date: 2023/1/9
 */
public class Dept {

    private String deptName;

    public Dept() {
        System.out.println("第一步：通过构造函数创建bean实例");
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
        System.out.println("第二步：调用set给bean的属性设置值");
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptName='" + deptName + '\'' +
                '}';
    }

    //初始化方法
    public void initDept(){
        System.out.println("第三步：调用Bean的初始化方法");
    }

    public void destroyMethod(){
        System.out.println("第五步：调用Bean的销毁方法");
    }
}
