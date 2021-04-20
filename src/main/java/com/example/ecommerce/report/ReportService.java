package com.example.ecommerce.report;

import java.util.List;

public interface ReportService {
    public List<Report> getReport(String userId, String year, String month);

    Rank getRank(String productId);
}
