package com.example.ecommerce.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ReportController {
    @Autowired
    ReportService reportService;
    @GetMapping("/report")
    public ResponseEntity<Map> getReport(@RequestParam("userId") String userId,
                                         @RequestParam("year") String year,
                                         @RequestParam("month") String month){
        Map<String,Object> response=new HashMap<String, Object>();
        response.put("Status","Success");
        response.put("StatusCode","S");
        response.put("Result",reportService.getReport(userId,year,month));
        return new ResponseEntity<Map>(response, HttpStatus.OK);
    }

    @GetMapping("/report/rank")
    public ResponseEntity<Map> getRank(@RequestParam("productId") String productId){
        Map<String,Object> response=new HashMap<String, Object>();
        response.put("Status","Success");
        response.put("StatusCode","S");
        response.put("Result",reportService.getRank(productId));
        return new ResponseEntity<Map>(response, HttpStatus.OK);
    }
}
