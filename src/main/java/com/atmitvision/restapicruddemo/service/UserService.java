package com.atmitvision.restapicruddemo.service;

import com.atmitvision.restapicruddemo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
}
