package org.javadev.clubmanagement.dao;

import org.javadev.clubmanagement.model.Product;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductsDao {

    protected Class modelType;

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<Product> getProducts(){

        CriteriaQuery<Product> criteriaQuery = em.getCriteriaBuilder().createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
