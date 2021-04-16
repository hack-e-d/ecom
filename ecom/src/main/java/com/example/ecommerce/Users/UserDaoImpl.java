package com.example.ecommerce.Users;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;
    @Autowired
    public UserDaoImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public Map<String, Object> getUserDetails() {
        Session currentSession = entityManager.unwrap(Session.class);
        String queryString = "select * from user ";
        NativeQuery query = currentSession.createNativeQuery(queryString);
        List<Object> resultList = query.getResultList();
        Map<String,Object> result=new HashMap<String, Object>();
        result.put("Result",resultList);
        return result;
    }
}
