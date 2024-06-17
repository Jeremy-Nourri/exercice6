package org.example.exercice6produitsj2ee.repository;


import org.example.exercice6produitsj2ee.exeption.NotFoundException;
import org.example.exercice6produitsj2ee.model.Product;
import org.hibernate.Transaction;

import java.util.List;

public class ProductRepository extends BaseRepository<Product> {

    public ProductRepository() {
        super();
    }

    @Override
    public Product add(Product product) {
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();
        }

        return product;
    }

    @Override
    public Product findById(int id) {
        Product product = null;

        try {
            session = sessionFactory.openSession();
            product = session.get(Product.class, id);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

        return product;
    }



    @Override
    public Product update(Product product) {
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }

    @Override
    public boolean delete(Product product) {
        Transaction transaction = null;
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
            result = true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();
        }

        return result;
    }

    public List<Product> findAll() {
        List<Product> products = null;

        try {
            session = sessionFactory.openSession();
            products = session.createQuery("from Product").list();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

        return products;
    }
}
