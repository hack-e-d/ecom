package com.example.ecommerce.purchase;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
@Transactional
public class PurchaseDAOImpl implements PurchaseDAO {
    private EntityManager entityManager;
    @Autowired
    public PurchaseDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Object> getPurchases() {
        Session session = entityManager.unwrap(Session.class);
        String queryString = "select * from purchase";
        NativeQuery query =session.createNativeQuery(queryString);
        List<Object> response = query.getResultList();
        return response;
    }
}
