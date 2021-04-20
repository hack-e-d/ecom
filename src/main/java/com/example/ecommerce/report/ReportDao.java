package com.example.ecommerce.report;

import java.util.List;

public interface ReportDao {
    public List<Object> getReport(String userId, String year, String month);

    List<Object> getRank(String productId);
}
