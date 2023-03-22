package com.company.spring5.JdbcTemplate.Service;/**
 * @author haifeng.zeng
 * @date 2023/2/8
 * @time 20:18
 * @package_name com.company.spring5.JdbcTemplate.Service
 * @project_name spring5FrameWork
 */

import com.company.spring5.JdbcTemplate.Dao.UserDao;
import com.company.spring5.JdbcTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/2/8
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(User user){
        userDao.addUser(user);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }

    public void deleteUser(String userCode){
        userDao.deleteUser(userCode);
    }

    public int selectCount(){
        return userDao.selectCount();
    }
}
