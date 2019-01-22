package com.lelo.productmicroservice.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.POJONode;
import com.lelo.productmicroservice.dto.MerchantDTO;
import com.lelo.productmicroservice.dto.MerchantDTOList;
import com.lelo.productmicroservice.dto.MerchantList;
import com.lelo.productmicroservice.dto.ProductMerchantResponseDTO;
import com.lelo.productmicroservice.entity.Category;
import com.lelo.productmicroservice.entity.Product;
import com.lelo.productmicroservice.entity.ProductMerchant;
import com.lelo.productmicroservice.entity.ProductMerchantIdentity;
import com.lelo.productmicroservice.repository.ProductMerchantRepository;
import com.lelo.productmicroservice.repository.ProductRepository;
import com.lelo.productmicroservice.service.ProductMerchantService;
import com.lelo.productmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductMerchantServiceImpl implements ProductMerchantService {

    @Autowired
    private ProductMerchantRepository productMerchantRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ProductMerchant getProductMerchant(ProductMerchantIdentity productMerchantIdentity) {
        return productMerchantRepository.findOne(productMerchantIdentity);
    }

    @Override
    public ProductMerchant addProductMerchant(ProductMerchant productMerchant) {
        return productMerchantRepository.save(productMerchant);
    }

    @Override
    public List<MerchantDTO> getMerchantFromProduct(String productId) {
        List<String> merchantIds = productMerchantRepository.findByProductId(productId);
        MerchantList merchantList = new MerchantList(merchantIds);
        final String uri = "https://merchant-lelo.herokuapp.com/merchant/getMerchantsByIds";
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity requestEntity=new HttpEntity(merchantIds, headers);
        List merchantDTOList;
        System.out.println(requestEntity.toString());
        ResponseEntity<?> entityResponse = restTemplate.exchange(uri, HttpMethod.POST,requestEntity,List.class);
        merchantDTOList = (List) entityResponse.getBody();
//        List<MerchantDTO> myObjects = mapper.readValue(entityResponse.getBody(), new TypeReference<List<MerchantDTO>>(){});
//        RestTemplate restTemplate = new RestTemplate();
//        List<MerchantDTOList> merchantDTOList = restTemplate.postForObject("https://merchant-lelo.herokuapp.com/merchant/getMerchantsByIds" ,merchantIds, List.class);
//        ResponseEntity<?> returns = restTemplate.postForEntity(uri, merchantList, MerchantList.class);
//        MerchantDTOList merchantDTOList = (MerchantDTOList) returns.getBody();
//        MerchantDTO result = restTemplate.getForObject(uri, MerchantDTO.class);
        Iterator iterator= merchantDTOList.iterator();
        List<MerchantDTO> merchantDTOS = new ArrayList<>();
        while (iterator.hasNext()) {
            MerchantDTO merchantDTO = mapper.convertValue(iterator.next(), MerchantDTO.class);
            merchantDTOS.add(merchantDTO);
        }
//        return null;
        return merchantDTOS;
    }
//    @Override
//    public List<ProductMerchant> findByMerchantId(String merchantId) {
//        return productMerchantRepository.findByMerchantId(merchantId);
//    }

//    @Override
//    public List<ProductMerchant> findByDifferentMerchantId(String productId, String merchantId) {
//        return productMerchantRepository.findByProductIdNotLikeMerchantId(productId, merchantId);
//    }

    @Override
    public boolean updateQuantity(ProductMerchant productMerchant, int quantitySold) {
        int newQuantity = productMerchant.getQuantityOffered() - quantitySold;
        productMerchant.setQuantitySold(productMerchant.getQuantitySold() + quantitySold);
        productMerchant.setQuantityOffered(newQuantity);
        ProductMerchant updatedProductMerchant = productMerchantRepository.save(productMerchant);
        if (updatedProductMerchant != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addRating(Product product, double rating) {
        double newRating = product.getRating() + rating;
        double newRatingCounter = product.getRatingCounter() + 1;
        product.setRating(newRating / newRatingCounter);
        product.setRatingCounter(newRatingCounter);
        Product updatedProduct = productRepository.save(product);
        if (updatedProduct != null){
            return true;
        } else {
            return false;
        }
    }
}
