package com.company.spring5.IOC.collectionType;/**
 * @author haifeng.zeng
 * @date 2023/1/9
 * @time 19:51
 * @package_name com.company.spring5.IOC.collectionType
 * @project_name spring5FrameWork
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *注释
 * 学生类
 *@author: haifeng.zeng
 *@date: 2023/1/9
 */
public class Student {
    //1，数组类型属性
    private String[] courses;
    //2,list集合类型
    private List<String> list;
    //3,map集合类型
    private Map<String,String> maps;
    //4,set集合类型
    private Set<String> sets;
    //4,List集合里面设置对象属性
    private List<Course> courseList;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void test(){
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(maps);
        System.out.println(sets);
        System.out.println(courseList);
    }
}
