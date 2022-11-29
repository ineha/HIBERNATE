package com.hibernate;

import com.hibernate.Fetch.Address;
import com.hibernate.Fetch.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "project started" );
        //for creating session factory we need to obtain object of configuration
        Configuration cfg = new Configuration();
        //give the path of xml file
        cfg.configure("hibernate.cfg.xml");
        //Creating session factory object
        SessionFactory factory= cfg.buildSessionFactory();
        //creating and setting object ----->>>>>> TRANSIENT STATE
        Student student=new Student();
        student.setId(2);
        student.setName("ram");
        student.setCity("delhi");
        System.out.println(student.toString());
        //creating object of address class
        Address address = new Address();
        address.setStreet("koyla nagar");
        address.setCity("delhi");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(234.56);


        //Reading image
        FileInputStream file = new FileInputStream("src/main/resources/static/2.jpg");
        byte[] data=new byte[file.available()];
        file.read(data);
        address.setImage(data);

        //creating session object
        Session currentSession = factory.openSession();
        //DEKHNE K LIYE
        Transaction tx=currentSession.beginTransaction();
        //session object takes object of student and then saving it to DB --->> PERSISTENCE STATE
        currentSession.save(student);
        currentSession.save(address);
        //for PHYSICALLY CHANGING  data in th db we need to commit the current transaction.
        //COMMIT krne se phle agar hm kuch change krnege to wo DB m chnge ho jayega that is because it is in PERSISTENCE STATE(attached with both session and DB)
        tx.commit();
        //close session ---------->>>DETACHED STATE
        currentSession.close();

        System.out.println("done");
        Integer a = new Integer(2);
        System.out.println(a.byteValue());

    }
}
