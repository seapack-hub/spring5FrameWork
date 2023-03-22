package com.company.spring5.testFrame;/**
 * @author haifeng.zeng
 * @date 2023/2/7
 * @time 19:33
 * @package_name com.company.spring5.testFrame
 * @project_name spring5FrameWork
 */

import com.company.spring5.AOP.aopxml.Book;
import com.company.spring5.AOP.aspectJ.ConfigAop;
import com.company.spring5.AOP.aspectJ.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *注释
 *测试类
 *@author: haifeng.zeng
 *@date: 2023/2/7
 */
public class TestAOP {

    //AspectJ 注解设置
    @Test
    public void testAop(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/AOP/aspectJ/aspectJ.xml");

        User user = context.getBean("user", User.class);
        user.add(1,2);
    }

    //完全注解开发
    @Test
    public void testAOPannotation(){
        //加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAop.class);
        //根据配置类创建对象
        User user = context.getBean("user",User.class);
        //调用方法
        user.add(1,2);

    }

    //配置开发
    @Test
    public void testAopXml(){
        //加载配置类
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/AOP/aopxml/aopxml.xml");
        //创建对象
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
