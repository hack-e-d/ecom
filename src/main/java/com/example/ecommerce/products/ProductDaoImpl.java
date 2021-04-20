package com.example.ecommerce.products;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
     private EntityManager entityManager;
     @Autowired
      public ProductDaoImpl(EntityManager theEntityManager){
         entityManager = theEntityManager;
    }
    @Override
    public List<Object> getProducts(String value) {
         Session currentSession = entityManager.unwrap(Session.class);
         String queryString = "select * from product ";
        NativeQuery query = currentSession.createNativeQuery(queryString);
        List<Object> resultList = query.getResultList();
        return resultList;
    }

    @Override

    public String addProductDetails(HashMap<String, Object> payload) {
        Session currentSession = entityManager.unwrap(Session.class);
        int trnStatus = 0;
        int trnStatus2=0;
        String queryString = "insert into product(product_id,product_name,product_description,price,product_category) values(?,?,?,?,?)";
        String queryString2 = "insert into product_history(product_id,product_name,product_description,price,product_category) values(?,?,?,?,?)";

//        try {
            trnStatus = currentSession.createNativeQuery(queryString).setParameter(1, payload.get("productId")).setParameter(2, payload.get("productName"))
                    .setParameter(3, payload.get("productDescription")).setParameter(4, payload.get("price"))
                    .setParameter(5, payload.get("category")).executeUpdate();

            trnStatus2 = currentSession.createNativeQuery(queryString2).setParameter(1, payload.get("productId")).setParameter(2, payload.get("productName"))
                .setParameter(3, payload.get("productDescription")).setParameter(4, payload.get("price"))
                .setParameter(5, payload.get("category")).executeUpdate();
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
        if(trnStatus>0)
            return "S";
        else
            return "F";
    }
    public String updateProductDetails(HashMap<String, Object> payload) {
        Session currentSession = entityManager.unwrap(Session.class);
        int trnStatus = 0;
        //int trnStatus2=0;
        String queryString = "update product set price = ? where product_id = ?";

//        try {
        trnStatus = currentSession.createNativeQuery(queryString).setParameter(2, payload.get("productId"))
                .setParameter(1, payload.get("price")).executeUpdate();


//        catch(Exception e){
//            System.out.println(e);
//        }
        if(trnStatus>0)
            return "S";
        else
            return "F";
    }
    public String deleteProductDetails(String productId) {
        Session currentSession = entityManager.unwrap(Session.class);
        String queryString = "update product set is_deleted = 1 where product_id = :id";
        int trnStatus = 0;

        trnStatus = currentSession.createNativeQuery(queryString).setParameter("id",productId)
                .executeUpdate();
        if(trnStatus>0)
            return "S";
        else
            return "F";
    }
}
