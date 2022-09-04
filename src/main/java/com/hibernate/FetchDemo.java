package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

    public class FetchDemo {
        public static void main(String[] args) {
        System.out.println("FETCHING STARTED");

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session= factory.openSession();
        Student student = (Student)session.load(Student.class, 2);
        System.out.println(student);
        Address address = (Address)session.load(Address.class,1);
            System.out.println(address.getStreet()+" : "+address.getCity()+" : "+address.getX());
    }
}
