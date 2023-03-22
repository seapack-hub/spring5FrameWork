package com.company.spring5.IOC.bean;/**
 * @author haifeng.zeng
 * @date 2023/1/12
 * @time 14:54
 * @package_name com.company.spring5.IOC.bean
 * @project_name spring5FrameWork
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/12
 */
public class MyBeanPost implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之前执行的方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之后执行的方法");
        return bean;
    }
}
