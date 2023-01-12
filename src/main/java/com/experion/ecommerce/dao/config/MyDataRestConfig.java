package com.experion.ecommerce.dao.config;


import com.experion.ecommerce.entity.Products;
import com.experion.ecommerce.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager){entityManager=theEntityManager;}

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        HttpMethod[] theUnsupportedActions = {};
        //disable http methods for product(post,put,delete)
        config.getExposureConfiguration()
                .forDomainType(Products.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
        config.getExposureConfiguration()
                .forDomainType(Users.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        //expose entity ids

        //get a list of all entity classes from entity manager
        Set<EntityType<?>>entities=entityManager.getMetamodel().getEntities();

        //create an array of entity types
        List<Class> entityClasses=new ArrayList<>();

        //get the entity typews for the entitie
        for(EntityType tempEntityType:entities){
            entityClasses.add(tempEntityType.getJavaType());
        }

        //expose the entity ids for the array of rntity/domaintypes
        Class[] domainTypes=entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }


}
