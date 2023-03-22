package com.company.spring5.testFrame;/**
 * @author haifeng.zeng
 * @date 2023/1/6
 * @time 8:58
 * @package_name com.company.spring5.testFrame
 * @project_name spring5FrameWork
 */

import com.company.spring5.IOC.bean.Dept;
import com.company.spring5.IOC.bean.Emp;
import com.company.spring5.IOC.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/6
 */
public class TestBeans {

    @Test
    public void testAdd(){
        System.out.println(3);
        //1.加载spring配置文件  ctrl+h 查看引用类  路径src下文件目录
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/IOC/beanDao.xml");

        //2.获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService);
        userService.add();
    }

    @Test
    public void testBean(){
        System.out.println(3);
        //1.加载spring配置文件  ctrl+h 查看引用类  路径src下文件目录
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/IOC/beanBean.xml");

        //2.获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        System.out.println(emp);
        emp.add();
    }

    @Test
    public void testDept(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/beanBean.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanXml/IOC/beanLifeCycle.xml");
        Dept dept = context.getBean("dept",Dept.class);
        System.out.println("第四步：获取Bean创建的对象");
        System.out.println(dept);

        //手动销毁Bean实例
//        ((ClassPathXmlApplicationContext)context).close();
        context.close();
    }
}
