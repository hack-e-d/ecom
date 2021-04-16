package com.example.ecommerce.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    ReportDao reportDao;
    @Override
    public List<Report> getReport(String userId, String year, String month) {
        List<Object> report = reportDao.getReport(userId, year, month);
        ArrayList<Report> reportArrayList=new ArrayList<Report>();
        Iterator iterator=report.iterator();
        while(iterator.hasNext()){
            Object[] tempArray= (Object[]) iterator.next();
            Report tempReport=new Report();
            tempReport.setProductCategory(String.valueOf(tempArray[0]));
            tempReport.setTotalCount(Double.parseDouble(String.valueOf(tempArray[1])));
            tempReport.setTotalSale(Double.parseDouble(String.valueOf(tempArray[2])));
            reportArrayList.add(tempReport);
        }
        return reportArrayList;
    }

    @Override
    public Rank getRank(String productId) {
        List<Object> rankList = reportDao.getRank(productId);
        Rank rank=new Rank();
        Iterator iterator=rankList.iterator();
        Object[] rankElementArray = (Object[]) iterator.next();
        rank.setProductId(String.valueOf(rankElementArray[0]));
        rank.setTotalCount(String.valueOf(rankElementArray[1]));
        rank.setRank(String.valueOf(rankElementArray[2]));
        return rank;
    }
}
