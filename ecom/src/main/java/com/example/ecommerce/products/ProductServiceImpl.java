package com.example.ecommerce.products;

//import org.springframework.stereotype.Component;
import com.example.ecommerce.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
//@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    Product product;
    User user;
    Address address;
    private static String URL;

    public Object getProducts(String value){
        List<Object> list = productDao.getProducts(value);
        Iterator iter = list.iterator();
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity(httpHeaders);
        ResponseEntity<Object> responseEntity = restTemplate.exchange(URL, HttpMethod.GET,requestEntity,Object.class);
        Object result = responseEntity.getBody();
        System.out.println(result.toString());
        return result;
//        ArrayList<Product> resultSet = new ArrayList<Product>();
//        while(iter.hasNext()){
//            Object[] arr = (Object[]) iter.next();
//            product = new Product();
//            product.setProductId(String.valueOf(arr[2]));
//            product.setProductName(String.valueOf(arr[3]));
//            product.setProductDescription(String.valueOf(arr[4]));
//            product.setCategory(String.valueOf(arr[5]));
//            product.setCount(String.valueOf(arr[6]));
//            product.setPrice(String.valueOf(arr[7]));
//            resultSet.add(product);
//        }
//
//          return resultSet;
//        hm.put("Result:",list);
//        return hm;
//        createProduct();
//        Map<String,Object> pdt = new HashMap<String,Object>();
//        pdt.put("productId",product.getProductId());
//        pdt.put("productName",product.getProductName());
//        pdt.put("productDescription",product.getProductDescription());
//        pdt.put("count",product.getCount());
//        pdt.put("price",product.getPrice());
//        pdt.put("category",product.getCategory());
        //return pdt;
    }
    public Map<String,Object> createProduct(){
//        List<Object> list = productDao.getProducts();
        Map<String,Object> hm = new HashMap<String,Object>();
//        hm.put("Result:",list);
//        hm.put("productId","p101");
//        hm.put("productName","Perfume");
//        hm.put("productDescription","Scene based");
//        hm.put("count","260");
//        hm.put("price","$20");
//        hm.put("category","HomeItems");
//        product = new Product();
//        assignProduct(hm,product);
        return hm;
    }
    public void assignProduct(Map<String,Object> hm,Product product) {

        product.setProductId(String.valueOf(hm.get("productId")));
        product.setProductName(String.valueOf(hm.get("productName")));
        product.setProductDescription(String.valueOf(hm.get("productDescription")));
        product.setCount(String.valueOf(hm.get("count")));
        product.setPrice(String.valueOf(hm.get("price")));
        product.setCategory(String.valueOf(hm.get("category")));

    }
    public Map<String,Object> getUserDetails(HashMap<String,Object> payload){
       user = new User();
       ArrayList<Address> addressList = new ArrayList<Address>();
       user.setUserId(String.valueOf(payload.get("userId")));
       user.setUserName(String.valueOf(payload.get("userName")));
       user.setPhoneNo(String.valueOf(payload.get("phoneNo")));
       user.setEmailId(String.valueOf(payload.get("emailId")));
       ArrayList<Object> addr = (ArrayList<Object>) payload.get("address");
       for(int i=0;i<addr.size();i++)
       {
           Map<String,Object> addres = (Map<String, Object>) addr.get(i);
           address = new Address();
           address.setDoorNo(String.valueOf(addres.get("doorNo")));
           address.setStreetName(String.valueOf(addres.get("streetName")));
           address.setArea(String.valueOf(addres.get("area")));
           addressList.add(address);
       }
       user.setAddress(addressList);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("userId",user.getUserId());
        result.put("userName",user.getUserName());
        result.put("address",user.getAddress());
        result.put("phoneNo",user.getPhoneNo());
        result.put("emailId",user.getEmailId());

        return result;
    }

    @Override
    public String addProductDetails(HashMap<String, Object> payload) {
        String status = productDao.addProductDetails(payload);
        if(status.equals("S"))
            return "Product Inserted Successfully";
        else
            return "Product Insertion Failed";
    }
    public String updateProductDetails(HashMap<String, Object> payload) {
        String status = productDao.updateProductDetails(payload);
        if(status.equals("S"))
            return "Product Updated Successfully";
        else
            return "Product Update Failed";
    }
    public String deleteProductDetails(String productId) {
        String status = productDao.deleteProductDetails(productId);
        if(status.equals("S"))
            return "Product Updated Successfully";
        else
            return "Product Update Failed";
    }

}
