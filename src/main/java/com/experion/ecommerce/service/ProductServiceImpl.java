package com.experion.ecommerce.service;

import com.experion.ecommerce.dao.ProductRepo;
import com.experion.ecommerce.dto.ProductPost;
import com.experion.ecommerce.entity.Products;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductServiceImpl implements ProductService{
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Products> getAllProducts(String category, String sort) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Products> criteriaQuery = criteriaBuilder.createQuery(Products.class);
        Root<Products> root = criteriaQuery.from(Products.class);
        if(sort !=null && !sort.isEmpty()) {
            if(sort.equalsIgnoreCase("asc")){
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("productPrice")));
                logger.info("Product Sorted in Ascending Order");
            }
            if(sort.equalsIgnoreCase("desc")){
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("productPrice")));
                logger.info("Product Sorted in Descending Order");
            }

        }
        if(category != null) {
            List<Predicate> predicates = new ArrayList<Predicate>();
            if(category != null && !category.isEmpty())
                predicates.add(criteriaBuilder.equal(root.get("productCategory"),category));
            if(sort !=null && !sort.isEmpty()) {
                if(sort.equalsIgnoreCase("asc")){
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get("productPrice")));
                    logger.info("Product Sorted Based on "+category+" in Ascending Order");
                }
                if(sort.equalsIgnoreCase("desc")){
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get("productPrice")));
                    logger.info("Product Sorted Based on "+category+" in Descending Order");
                }
            }

            criteriaQuery.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        }

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public ProductPost addProduct(ProductPost request) {
        Products products = new Products();
        BeanUtils.copyProperties(request,products);
        products.setProductId(request.getProductId());
        products.setProductName(request.getProductName());
        products.setProductType(request.getProductType());
        products.setProductPrice(request.getProductPrice());
        products.setProductImage(request.getProductImage());
        productRepo.save(products);
        return request;
    }

}
