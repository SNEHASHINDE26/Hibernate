package demo;


import domain.Education;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertEducationalDetails {
    public static void main(String[]args){

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Student Name : ");
        String name=sc.next();
        System.out.println("Enter Student ContactNO. : ");
        String contact=sc.next();
        System.out.println("Enter SSC Marks : ");
        double ssc=sc.nextDouble();
        System.out.println("Enter HSC Marks : ");
        double hsc=sc.nextDouble();
        System.out.println("Enter Degree Marks :");
        double degree=sc.nextDouble();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Education.class);
        cfg=cfg.addAnnotatedClass(Student.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        //create object of Education
        Education e1=new Education();
        e1.setSsc(ssc);
        e1.setHsc(hsc);
        e1.setDegree(degree);

        //create object of Student
        Student s1 =new Student();
        s1.setStudentName(name);
        s1.setStudentContact(contact);

        //assign education details to student object
        s1.setEidInfo(e1);
        tx=ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("Details Inserted Successfully");
    }
}
