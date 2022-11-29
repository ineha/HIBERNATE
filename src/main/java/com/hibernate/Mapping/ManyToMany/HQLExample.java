package com.hibernate.Mapping.ManyToMany;

import com.hibernate.Fetch.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();




        Session session= factory.openSession();
        //Transaction tx=session.beginTransaction();
        String query ="from Emp";
        Query q =session.createQuery(query);

       List<Emp> resultList = q.list();

        for (Emp i:resultList) {
            System.out.println("hi");
            System.out.println(i.getName());
        }


        session.close();

    }

}
