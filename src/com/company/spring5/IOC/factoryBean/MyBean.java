package com.company.spring5.IOC.factoryBean;/**
 * @author haifeng.zeng
 * @date 2023/1/11
 * @time 20:31
 * @package_name com.company.spring5.IOC.factoryBean
 * @project_name spring5FrameWork
 */

import com.company.spring5.IOC.collectionType.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/11
 */
public class MyBean implements FactoryBean{
    @Override
    public Object getObject() throws Exception {
        Course course = new Course();
        course.setCourseName("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
