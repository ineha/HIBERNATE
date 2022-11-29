package com.hibernate.Mapping.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

Emp e1=new Emp();
        Emp e2=new Emp();
e1.setEid(1);
e2.setEid(2);
e1.setName("ram");
e2.setName("shyam");

Project p1=new Project();
p1.setPid(3);
p1.setProjectName("Library mngmnt system");

Project p2=new Project();
p2.setPid(4);
p2.setProjectName("chatbot");

        List<Project> listproj=new ArrayList<>();
        listproj.add(p1);
        listproj.add(p2);
        List<Emp> listemp=new ArrayList<>();
        listemp.add(e1);
        listemp.add(e2);

        e1.setProjects(listproj);

        p2.setEmps(listemp);

        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();

        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);


        tx.commit();


        session.close();
    }
}
