package com.eafonasyev.classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eafonasyev.classes.entities.Student;

public class Main {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 0;

           session.beginTransaction();

           session.createQuery("delete Student where id = 1").executeUpdate();

           session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }


        }
