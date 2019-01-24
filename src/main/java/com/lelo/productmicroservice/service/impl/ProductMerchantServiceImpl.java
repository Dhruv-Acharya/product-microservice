package com.lelo.productmicroservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lelo.productmicroservice.Utilities.Constans;
import com.lelo.productmicroservice.dto.MerchantDTO;
import com.lelo.productmicroservice.dto.MerchantListDTO;
import com.lelo.productmicroservice.dto.MerchantListResponseDTO;
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

    @Autowired
    private ProductService productService;



    @Override
    public ProductMerchant getProductMerchant(ProductMerchantIdentity productMerchantIdentity) {
        return productMerchantRepository.findOne(productMerchantIdentity);
    }

    @Override
    public ProductMerchant addProductMerchant(ProductMerchant productMerchant) {
        return productMerchantRepository.save(productMerchant);
    }

    @Override
    public List<MerchantListResponseDTO> getMerchantFromProduct(String productId) {
        List<String> merchantIds = productMerchantRepository.findByProductId(productId);
//        MerchantList merchantList = new MerchantList(merchantIds);
        final String uri = Constans.MERCHANT_MICROSERVICE_BASE_URL + "/merchant/getMerchantsByIds";
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
        List<MerchantListDTO> merchantListAlgo = new ArrayList<>();
        List<MerchantListResponseDTO> merchantDTOS = new ArrayList<>();
        while (iterator.hasNext()) {
            MerchantDTO merchantDTO = mapper.convertValue(iterator.next(), MerchantDTO.class);
            MerchantListDTO merchantListDTOAlog = new MerchantListDTO();

            //response
//            MerchantListResponseDTO merchantListResponseDTO = new MerchantListResponseDTO();
//            merchantListResponseDTO.setMerchantId(merchantDTO.getMerchantId());
//            merchantListResponseDTO.setName(merchantDTO.getName());

            //for alog
            merchantListDTOAlog.setMerchantId(merchantDTO.getMerchantId());
            merchantListDTOAlog.setName(merchantDTO.getName());
            merchantListDTOAlog.setEmailId(merchantDTO.getEmailId());
            merchantListDTOAlog.setMerchantRating(merchantDTO.getRating());

            ProductMerchantIdentity productMerchantIdentity = new ProductMerchantIdentity(productId,merchantDTO.getMerchantId());
            ProductMerchant productMerchant = this.getProductMerchant(productMerchantIdentity);

            merchantListDTOAlog.setDiscount(productMerchant.getDiscount());
            merchantListDTOAlog.setPrice(productMerchant.getPrice());
            merchantListDTOAlog.setQuantitySold(productMerchant.getQuantitySold());
            merchantListDTOAlog.setQuantityOffered(productMerchant.getQuantityOffered());

//            merchantListResponseDTO.setDiscount(productMerchant.getDiscount());
//            merchantListResponseDTO.setPrice(productMerchant.getPrice());



            Product product = productService.findOne(productId);
            merchantListDTOAlog.setProductRating(product.getRating());
//            merchantListResponseDTO.setRating(product.getRating());
//            merchantListResponseDTO.set;
//            System.out.println(merchantListDTOAlog.toString());
            merchantListAlgo.add(merchantListDTOAlog);
        }
        merchantDTOS = rankMerchant(merchantListAlgo);
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

    public List<MerchantListResponseDTO> rankMerchant(List<MerchantListDTO> merchantListDTOAlgo) {
        List<MerchantListResponseDTO> merchantListResponseDTOList = new ArrayList<>();
        int listSize = merchantListDTOAlgo.size();
        double[] mRate = new double[listSize];

        double[] price = new double[listSize];
        double[] productRating = new double[listSize];
        double[] discount = new double[listSize];
        int[] mQuantityOffered = new int[listSize];
        int[] quantitySold = new int[listSize];
        double[] overallValue = new double[listSize];
        MerchantListResponseDTO merchantListResponseDTO = new MerchantListResponseDTO();
        for (int i=0;i<merchantListDTOAlgo.size();i++) {

            mRate[i]=merchantListDTOAlgo.get(i).getMerchantRating();
            merchantListResponseDTO.setMerchantId(merchantListDTOAlgo.get(i).getMerchantId());
            merchantListResponseDTO.setDiscount(merchantListDTOAlgo.get(i).getDiscount());
            merchantListResponseDTO.setEmailId(merchantListDTOAlgo.get(i).getEmailId());
            merchantListResponseDTO.setName(merchantListDTOAlgo.get(i).getName());
            merchantListResponseDTO.setQunatity(merchantListDTOAlgo.get(i).getQuantityOffered());
            merchantListResponseDTO.setPrice(merchantListDTOAlgo.get(i).getPrice());
            price[i]=merchantListDTOAlgo.get(i).getPrice();
            productRating[i]=merchantListDTOAlgo.get(i).getProductRating();
            discount[i]=merchantListDTOAlgo.get(i).getDiscount();
            mQuantityOffered[i]=merchantListDTOAlgo.get(i).getQuantityOffered();
            quantitySold[i]=merchantListDTOAlgo.get(i).getQuantitySold();
            overallValue[i]=(price[i]*1/3)+(mRate[i]*1/6)+(discount[i]*1/4)+(quantitySold[i]*1/6)+(mQuantityOffered[i]*1/12);
            merchantListResponseDTOList.add(merchantListResponseDTO);
        }
        int[] rank = new int[listSize];
        for (int i=0;i<listSize;i++){
            rank[i]=i+1;
        }
        for (int i=0;i<listSize;i++){
            for (int j=i;j<listSize;j++){
                if(overallValue[i]<overallValue[j]){
                    int temp = rank[i];
                    rank[i]=rank[j];
                    rank[j]=temp;
                }
            }
            merchantListResponseDTOList.get(i).setRating((merchantListResponseDTOList.get(i).getRating()+(listSize/rank[i]))/2);
        }
        for(int i = 0;i<listSize;i++){
            for (int j = i;j<listSize;j++){
                if(merchantListResponseDTOList.get(i).getRating()<merchantListResponseDTOList.get(j).getRating()){
                    MerchantListResponseDTO merchantListResponseDTO1 = merchantListResponseDTOList.get(i);
                    merchantListResponseDTOList.set(i, merchantListResponseDTOList.get(j));
                    merchantListResponseDTOList.set(j, merchantListResponseDTO1);
                }
            }
        }
        return merchantListResponseDTOList;
    }
}
