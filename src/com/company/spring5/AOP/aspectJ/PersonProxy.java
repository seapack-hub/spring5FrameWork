package com.company.spring5.AOP.aspectJ;/**
 * @author haifeng.zeng
 * @date 2023/2/7
 * @time 20:10
 * @package_name com.company.spring5.AOP.aspectJ
 * @project_name spring5FrameWork
 */

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/2/7
 */
@Component
@Aspect
@Order(1)
public class PersonProxy {
    //前置通知
    //语法结构： execution([权限修饰符] [返回类型] [类全路径] [方法名称]([参数列表]) )
    @Before(value = "execution(* com.company.spring5.AOP.aspectJ.User.add(..))")
    public void before(){
        System.out.println("PersonProxy before.......");
    }

    //后置通知
    @AfterReturning(value = "execution(* com.company.spring5.AOP.aspectJ.User.add(..))")
    public void afterReturning(){
        System.out.println("PersonProxy afterReturning........");
    }
}
