package demo;

import domain.Citizen;
import domain.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Hibernate1To1 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter citizen name : ");
        String name=sc.next();
        System.out.println("Enter citizen age : ");
        int age=sc.nextInt();
        System.out.println("Enter passport number : ");
        String passNo=sc.next();
        System.out.println("Enter country : ");
        String country=sc.next();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Passport.class);
        cfg=cfg.addAnnotatedClass(Citizen.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        //create object of passport
        Passport p1=new Passport();
        p1.setPassportNo(passNo);
        p1.setCountryName(country);

        //create object of citizen
        Citizen c1 =new Citizen();
        c1.setCitizenName(name);
        c1.setCitizenAge(age);

        //assign passport details to citizen object
        c1.setPassportRef(p1);
        tx=ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        System.out.println("Details Inserted Successfully");
    }

}
