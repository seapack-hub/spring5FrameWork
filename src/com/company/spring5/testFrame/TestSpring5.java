package com.company.spring5.testFrame;/**
 * @author haifeng.zeng
 * @date 2023/1/6
 * @time 8:58
 * @package_name com.company.spring5.testFrame
 * @project_name spring5FrameWork
 */

//import com.company.spring5.IOC.Book;
import com.company.spring5.IOC.Orders;
import com.company.spring5.IOC.User;
import com.company.spring5.IOC.autowire.Emp;
import com.company.spring5.IOC.collectionType.Book;
import com.company.spring5.IOC.collectionType.Course;
import com.company.spring5.IOC.collectionType.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/6
 */
public class TestSpring5 {

    @Test
    public void testAdd(){
        //1.加载spring配置文件  ctrl+h 查看引用类  路径src下文件目录
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/IOC/beanUser.xml");
//        BeanFactory context = new ClassPathXmlApplicationContext("beanUser.xml");

        //2.获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();
    }

//    @Test
//    public void testBook(){
//        //1.加载spring配置文件  ctrl+h 查看引用类  路径src下文件目录
//        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/beanUser.xml");
//
//        //2.获取配置创建的对象
//        Book book = context.getBean("book", Book.class);
//
//        System.out.println(book);
//        book.bookTest();
//    }

    @Test
    public void testOrder(){
        //1.加载spring配置文件  ctrl+h 查看引用类  路径src下文件目录
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/IOC/beanUser.xml");
//        BeanFactory context = new ClassPathXmlApplicationContext("beanUser.xml");

        //2.获取配置创建的对象
        Orders orders = context.getBean("orders", Orders.class);

        System.out.println(orders);
        orders.OrderTest();
    }

    @Test
    public void testCollection(){
        //1.加载spring配置文件  ctrl+h 查看引用类  路径src下文件目录
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/IOC/beanCollection.xml");
//        BeanFactory context = new ClassPathXmlApplicationContext("beanUser.xml");

        //2.获取配置创建的对象
        Student student = context.getBean("student", Student.class);

//        System.out.println(student);
        student.test();
    }

    @Test
    public void testCollectionBook(){
        //1.加载spring配置文件  ctrl+h 查看引用类  路径src下文件目录
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/IOC/beanExtract.xml");

        //2.获取配置创建的对象
        Book book1 = context.getBean("book", Book.class);

        Book book2 = context.getBean("book", Book.class);
        System.out.println(book1);
        System.out.println(book2);
    }

    @Test
    public void testFactoryBean(){
        //1.加载spring配置文件  ctrl+h 查看引用类  路径src下文件目录
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/IOC/beanFactory.xml");

        //2.获取配置创建的对象
        Course myBean = context.getBean("myBean", Course.class);
        System.out.println(myBean);
    }

    @Test
    public void testFactoryBean2(){
        //1.加载spring配置文件  ctrl+h 查看引用类  路径src下文件目录
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/IOC/beanFactory.xml");

        //2.获取配置创建的对象
        Course myBean1 = context.getBean("myBean", Course.class);
        Course myBean2 = context.getBean("myBean", Course.class);
        System.out.println(myBean1);
        System.out.println(myBean2);
    }

    @Test
    public void testAutowire(){
        //1.加载spring配置文件  ctrl+h 查看引用类  路径src下文件目录
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/IOC/beanAutowire.xml");

        //2.获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }


}
