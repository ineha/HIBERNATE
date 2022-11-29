package com.hibernate.Mapping.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Person person =new Person();
        person.setName("ram");
        person.setPid(123);

        List<Phone> list = new ArrayList<>();
        Phone phone1= new Phone();
        phone1.setPhoneId(234);
        phone1.setModel("samsung");

        Phone phone2= new Phone();
        phone2.setPhoneId(345);
        phone2.setModel("moto");

        list.add(phone1);
        list.add(phone2);
        person.setPhones(list);


        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();

        session.save(person);
        session.save(phone1);
        session.save(phone2);

        System.out.println(phone1.getPerson().getPid());
        tx.commit();


        session.close();


    }
}
