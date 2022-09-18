package com.eafonasyev.classes;

import com.eafonasyev.classes.entities.Course;
import com.eafonasyev.classes.entities.Instractor;
import com.eafonasyev.classes.entities.InstractorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eafonasyev.classes.entities.Student;

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
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.getTransaction().begin();
            Object courses = new Course();
            courses = session.get(Course.class,15);

            session.delete(courses);

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
