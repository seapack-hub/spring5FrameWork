package com.company.spring5.AOP.aspectJ;/**
 * @author haifeng.zeng
 * @date 2023/2/7
 * @time 19:20
 * @package_name com.company.spring5.AOP.aspectJ
 * @project_name spring5FrameWork
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *注释
 * User的增强类
 *@author: haifeng.zeng
 *@date: 2023/2/7
 */
@Component
@Aspect
@Order(3)
public class UserProxy {


    //切入点抽取
    @Pointcut(value="execution(* com.company.spring5.AOP.aspectJ.User.add(..))")
    public void demo(){

    }

    //前置通知
    //语法结构： execution([权限修饰符] [返回类型] [类全路径] [方法名称]([参数列表]) )
    @Before(value = "demo()")
    public void before(){
        System.out.println("before.......");
    }

    //后置通知
    @AfterReturning(value = "execution(* com.company.spring5.AOP.aspectJ.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning........");
    }

    //最终通知
    @After(value = "execution(* com.company.spring5.AOP.aspectJ.User.add(..))")
    public void after(){
        System.out.println("after........");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.company.spring5.AOP.aspectJ.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing........");
    }

    //环绕通知
    @Around(value = "execution(* com.company.spring5.AOP.aspectJ.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕之前.......");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后........");
    }

}
