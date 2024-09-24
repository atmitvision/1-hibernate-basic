package com.atmitvision.restapicruddemo.service;

import com.atmitvision.restapicruddemo.dao.RoleDao;
import com.atmitvision.restapicruddemo.dao.UserDao;
import com.atmitvision.restapicruddemo.entity.Role;
import com.atmitvision.restapicruddemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    private RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDao.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("Invalid UserName or Password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),
                mapRoletoAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRoletoAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
