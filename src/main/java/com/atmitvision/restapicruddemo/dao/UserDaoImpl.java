package com.atmitvision.restapicruddemo.dao;

import com.atmitvision.restapicruddemo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    private EntityManager entityManager;

    public UserDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public User findByUserName(String name) {
        String queryString = "from User where userName=:userName and enabled=true";
        TypedQuery<User> typedQuery=entityManager.createQuery(queryString, User.class);
        typedQuery.setParameter("userName",name);
        User user=null;
        try{
            user=typedQuery.getSingleResult();
        }catch (Exception e){
            user=null;
        }
        return user;
    }
}
