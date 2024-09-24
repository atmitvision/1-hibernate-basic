package com.atmitvision.restapicruddemo.dao;

import com.atmitvision.restapicruddemo.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao{
    private EntityManager entityManager;

    public RoleDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public Role findByRoleName(String roleName) {
        String queryString="from Role where name=:roleName";
        TypedQuery<Role> typedQuery=entityManager.createQuery(queryString,Role.class);
        typedQuery.setParameter("roleName",roleName);
        Role role=null;
        try{
            role=typedQuery.getSingleResult();
        }catch (Exception e){
            role=null;
        }
        return role;
    }
}
