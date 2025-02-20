package com.btc.rwserver.Controllers;

import com.btc.rwserver.Models.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Properties;

public class HibernateController {
    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Robot.class)
            .buildSessionFactory();

    public static void addObject(Object object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(object);

        session.getTransaction().commit();
        session.close();
    }

    public static Object getObject(Class<?> objectClass, Object id) {
        Session session = sessionFactory.openSession();

        Object object = session.get(objectClass, id);

        session.close();
        return object;
    }

    public static void removeObject(Object object, long index) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Object data = session.get(Object.class, index + 1);
        session.remove(data);

        session.getTransaction().commit();
        session.close();
    }

    public static void modifyObject(Object modifiedObject) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.merge(modifiedObject);

        session.getTransaction().commit();
        session.close();
    }

    public static <T> List<T> getAllEntries(Class<T> objectClass) {
        Session session = sessionFactory.openSession();
        List<T> resultList = null;

        try {
            session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(objectClass);
            Root<T> rootEntry = cq.from(objectClass);
            CriteriaQuery<T> all = cq.select(rootEntry);

            resultList = session.createQuery(all).getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return resultList;
    }
}
