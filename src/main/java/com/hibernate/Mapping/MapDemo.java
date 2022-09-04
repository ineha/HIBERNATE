package com.hibernate.Mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Question question = new Question();
        question.setQuestionId(312);
        question.setQuestion("what is java");
        Answer answer = new Answer();
        answer.setAnswerId(123);
        answer.setAnswer("Java is a platform independent language for software development");
        question.setAnswer(answer);
        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(question);
        session.save(answer);
        tx.commit();
        session.close();


    }
}
