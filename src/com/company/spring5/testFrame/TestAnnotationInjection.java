package com.company.spring5.testFrame;/**
 * @author haifeng.zeng
 * @date 2023/1/16
 * @time 19:58
 * @package_name com.company.spring5.testFrame
 * @project_name spring5FrameWork
 */

import com.company.spring5.IOC.note.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/16
 */

public class TestAnnotationInjection {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanXml/IOC/beanNote.xml");
        UserService userServices = context.getBean("userService", UserService.class);
        System.out.println(userServices);
        userServices.add();

    }

//    @Test
//    public void testConfig(){
//        //加载配置类
//        ApplicationContext context;
//        context = new AnnotationConfigApplicationContext(SpringC);
//        UserService userServices = context.getBean("userService", UserService.class);
//        System.out.println(userServices);
//        userServices.add();
//    }

}
