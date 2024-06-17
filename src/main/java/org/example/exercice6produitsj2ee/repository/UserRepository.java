package org.example.exercice6produitsj2ee.repository;

import org.example.exercice6produitsj2ee.exeption.NotFoundException;
import org.example.exercice6produitsj2ee.model.User;
import org.hibernate.Transaction;

public class UserRepository extends BaseRepository<User> {

    public UserRepository() {
        super();
    }

    @Override
    public User add(User user) {

        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try {
            session = sessionFactory.openSession();
            user = session.get(User.class, id);
            if (user == null) {
                throw new NotFoundException("User not found");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

        return user;
    }

    public User findByEmail(String email) {
        User user = null;
        System.out.println(email);
        try {
            session = sessionFactory.openSession();
            user = (User) session.createQuery("from User where email = :email")
                    .setParameter("email", email)
                    .uniqueResult();
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public User update(User user) {
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public boolean delete(User user) {
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
