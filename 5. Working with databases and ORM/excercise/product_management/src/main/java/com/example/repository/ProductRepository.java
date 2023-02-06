package com.example.repository;

import com.example.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
@PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {
//        Session session = null;
        List<Product>productList;
        productList = entityManager.createQuery("from Product ").getResultList();
//        try {
//          session = ConnectionUtils.sessionFactory.openSession();
//          productList = session.createQuery("from Product ").list();
//        } finally {
//            if(session != null){
//                session.close();
//            }
//        }
        return productList;
    }

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
//        Session session = null;
//        Transaction transaction = null;
//        try {
//            session = ConnectionUtils.sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.save(product);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
    }

    @Override
    @Transactional
    public void edit(Product product) {
    Product product1 = findById(product.getId());
    product1.setName(product.getName());
    product1.setPrice(product.getPrice());
    product1.setDescribe1(product.getDescribe1());
    product1.setProducer(product.getProducer());
    entityManager.merge(product1);
    }

    @Override
    @Transactional
    public void remove(int id) {
        Product product2 = findById(id);
        entityManager.remove(product2);
//        Session session = null;
//        try {
//            session = ConnectionUtils.sessionFactory.openSession();
//            session.delete(product2);
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
    }

    @Override
    public Product findById(int id) {
        Product product2 = entityManager.find(Product.class,id);
//        Session session = null;
//        try {
//            session = ConnectionUtils.sessionFactory.openSession();
//            product2 = (Product) session.createQuery("from Product where id = :id").setParameter("id",id).getSingleResult();
//        }finally {
//            if (session!=null){
//                session.close();
//            }
//        }
        return product2;
    }

    @Override
    public List<Product> findProduct(String name) {
//        TypedQuery<Product> query = ConnectionUtils.sessionFactory.openSession().createQuery("SELECT c FROM Product AS c WHERE c.name like :param");
//        query.setParameter("param", "%" + name + "%");
        List<Product>productList;
        productList=entityManager.createQuery("select p from Product AS p where p.name like :param").setParameter("param","%"+name+"%").getResultList();
        return productList;
    }
}
