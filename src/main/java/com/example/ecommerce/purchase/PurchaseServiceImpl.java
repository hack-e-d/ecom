package com.example.ecommerce.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchaseDAO purchaseDAO;
    @Override
    public List<Purchase> getPurchases() {
        List<Object> daoResponse=purchaseDAO.getPurchases();
        List<Purchase> purchaseList = new ArrayList<Purchase>();
        Iterator iterator = daoResponse.iterator();
        while(iterator.hasNext()){
            Purchase purchase=new Purchase();
            Object[] tempArray = (Object[]) iterator.next();
            purchase.setProductId(String.valueOf(tempArray[2]));
            purchase.setPurchaseId(String.valueOf(tempArray[1]));
            purchase.setProductCount(String.valueOf(tempArray[3]));
            purchaseList.add(purchase);
        }
        return purchaseList;
    }
}
