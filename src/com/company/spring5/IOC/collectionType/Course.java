package com.company.spring5.IOC.collectionType;/**
 * @author haifeng.zeng
 * @date 2023/1/10
 * @time 8:53
 * @package_name com.company.spring5.IOC.collectionType
 * @project_name spring5FrameWork
 */

/**
 *注释
 *课程类
 *@author: haifeng.zeng
 *@date: 2023/1/10
 */
public class Course {

    private String courseName;

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                '}';
    }
}
