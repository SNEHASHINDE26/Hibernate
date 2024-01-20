package Demo;

import Domain.Course1;
import Domain.Student1;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class AcceptStudentIdAndDeleteStudentDetails10 {
    public static void main(String[]args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student1.class);
        cfg = cfg.addAnnotatedClass(Course1.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the student id");
        int id= sc.nextInt();

        Student1 s1=ses.get(Student1.class,id);
        System.out.println(s1);
        tx=ses.beginTransaction();
        ses.delete(s1);
        tx.commit();
        System.out.println("Student Deleted");



    }
}
