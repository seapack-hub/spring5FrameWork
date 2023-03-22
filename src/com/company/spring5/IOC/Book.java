package com.company.spring5.IOC;/**
 * @author haifeng.zeng
 * @date 2023/1/6
 * @time 16:57
 * @package_name com.company.spring5
 * @project_name spring5FrameWork
 */

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/6
 */
public class Book {
    //创建属性
    private String bookName;
    private String bookAuthor;
    private String address;
    //创建属性对应的 set 方法
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public static void main(String[] args) {
//        Book book = new Book();
//        book.setBookName("八次危机");
//        book.setBookAuthor("温铁军");
//    }

    public void bookTest(){
        System.out.println(bookName+";"+bookAuthor+"::"+address);
    }
}
