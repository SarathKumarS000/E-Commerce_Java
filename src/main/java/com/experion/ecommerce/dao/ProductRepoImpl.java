package com.experion.ecommerce.dao;

import com.experion.ecommerce.controller.UserController;
import com.experion.ecommerce.entity.Products;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepoImpl implements ProductRepo{

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Products> getAllProducts(String type, String sort) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Products> criteriaQuery = criteriaBuilder.createQuery(Products.class);
        Root<Products> root = criteriaQuery.from(Products.class);
        if (sort != null && !sort.isEmpty()) {
            logger.info("sort before "+sort);
            if (sort.equalsIgnoreCase("desc")) {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("productPrice")));
                logger.info("sort before category selected"+sort);
                System.out.println("dddd" + sort);
            }
            if (sort.equalsIgnoreCase("asc")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("productPrice")));
                logger.info("sort before category selected"+sort);
            }

        }
        if (type != null) {
            List<Predicate> predicates = new ArrayList<Predicate>();
            if (type != null && !type.isEmpty())
                predicates.add(criteriaBuilder.equal(root.get("productType"), type));
            if (sort != null && !sort.isEmpty()) {
                if (sort.equalsIgnoreCase("desc")) {
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get("productPrice")));
                    logger.info("sort before category selected"+sort);
                    System.out.println("dddd" + sort);
                }
                if (sort.equalsIgnoreCase("asc")) {
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get("productPrice")));
                    logger.info("sort before category selected"+sort);
                }
            }

            criteriaQuery.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        }

        return entityManager.createQuery(criteriaQuery).getResultList();

    }

}
