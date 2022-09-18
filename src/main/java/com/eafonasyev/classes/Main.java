package com.eafonasyev.classes;

import com.eafonasyev.classes.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {



    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instractor.class)
                .addAnnotatedClass(InstractorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.getTransaction().begin();

            int courseId=1900;

            Object course;

            course = session.get(Course.class,courseId);

            session.delete(course);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
           // session.close();
            factory.close();
        }
    }
}
