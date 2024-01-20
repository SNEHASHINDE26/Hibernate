package demo;

import domain.Education;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DisplayNameDegree {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Student Id");
        int id= sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Education.class);
        cfg=cfg.addAnnotatedClass(Student.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Student s1=ses.load(Student.class,id);
        String name=s1.getStudentName();

        //get Education reference from citizen class
        Education ref=s1.getEidInfo();
        double degree1=ref.getDegree();
        System.out.println(name+"\t\t"+degree1);

    }
}
