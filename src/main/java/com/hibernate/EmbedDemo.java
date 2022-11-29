package com.hibernate;

import com.hibernate.Fetch.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
    public static void main(String[] args) {

        System.out.println("Embed STARTED");

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Student student=new Student();
        student.setId(3);
        student.setName("Naina");
        student.setCity("delhi");
        Certificate certificate=new Certificate("java",2);

        student.setCerti(certificate);
        Student student1=new Student();
        student1.setId(4);
        student1.setName("sita");
        student1.setCity("mumbai");
        Certificate certificate1 =new Certificate();
        certificate1.setCourse("c++");
        certificate1.setDuration(3);
        student1.setCerti(certificate1);
        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(student);
        session.save(student1);
        tx.commit();
        session.close();
    }
}
