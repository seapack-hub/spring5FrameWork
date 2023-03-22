package com.company.spring5.testFrame;/**
 * @author haifeng.zeng
 * @date 2023/2/9
 * @time 12:27
 * @package_name com.company.spring5.testFrame
 * @project_name spring5FrameWork
 */

import com.company.spring5.JdbcTemplate.Service.UserService;
import com.company.spring5.JdbcTemplate.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/2/9
 */
public class TestJdbcTemplate {

    @Test
    public void testJdbcConnect(){
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/JdbcTemplate/Jdbc.xml");
        //创建对象
        UserService userService = context.getBean("userService",UserService.class);
        User user = new User();
        user.setUserCode("666");
        user.setUserName("海峰");
        user.setCompany("金仕达");
        userService.addUser(user);
    }

    @Test
    public void testUserUpdate(){
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/JdbcTemplate/Jdbc.xml");
        //创建对象
        UserService userService = context.getBean("userService",UserService.class);
        User user = new User();
        user.setUserCode("666");
        user.setUserName("海峰牛逼");
        user.setCompany("金仕达");
        userService.updateUser(user);
    }

    @Test
    public void testUserDelete(){
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/JdbcTemplate/Jdbc.xml");
        //创建对象
        UserService userService = context.getBean("userService",UserService.class);
        userService.deleteUser("666");
    }

    @Test
    public void testSelectCount(){
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/JdbcTemplate/Jdbc.xml");
        //创建对象
        UserService userService = context.getBean("userService",UserService.class);
        int index = userService.selectCount();
        System.out.println(index);
    }

}
