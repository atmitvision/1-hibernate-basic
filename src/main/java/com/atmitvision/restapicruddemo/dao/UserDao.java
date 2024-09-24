package com.atmitvision.restapicruddemo.dao;

import com.atmitvision.restapicruddemo.entity.User;

public interface UserDao {
    User findByUserName(String name);
}
