package com.example.ecommerce.report;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class ReportDaoImpl implements ReportDao{
    private EntityManager entityManager;
    @Autowired
    public ReportDaoImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    public List<Object> getReport(String userId, String year, String month) {
        Session session=entityManager.unwrap(Session.class);
        String queryString="select pd.product_category,sum(pr.product_count) " +
                "as total_count,sum(pd.price*pr.product_count) as total_sale " +
                "from product pd join purchase pr on pd.product_id = pr.product_id " +
                "where year(pr.created_at) = ? and month(pr.created_at) = ? and " +
                "pd.user_id =? group by pd.product_category;";
        NativeQuery query=session.createNativeQuery(queryString);
        query.setParameter(3,userId);
        query.setParameter(1,year);
        query.setParameter(2,month);
        List<Object> reportList = query.getResultList();
        return reportList;
    }

    @Override
    public List<Object> getRank(String productId) {
        Session session=entityManager.unwrap(Session.class);
        String queryString="Select * from (Select product_id, SUM(product_count) as total_count,\n" +
                "RANK() OVER (ORDER BY SUM(product_count) DESC)\n" +
                " from purchase where product_id in\n" +
                "(Select product_id from product where product_category = (\n" +
                "Select product_category from product where product_id = ?\n" +
                "))\n" +
                "Group By product_id\n" +
                "Order By total_count DESC) as table1 where \n" +
                "product_id = ?";
        NativeQuery query = session.createNativeQuery(queryString);
        query.setParameter(1,productId);
        query.setParameter(2,productId);
        List<Object> rankList=query.getResultList();
        return rankList;
    }
}
