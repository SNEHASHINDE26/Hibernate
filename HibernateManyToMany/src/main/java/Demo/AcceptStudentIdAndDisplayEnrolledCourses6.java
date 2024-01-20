package Demo;

import Domain.Course1;
import Domain.Student1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class AcceptStudentIdAndDisplayEnrolledCourses6 {
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

        Student1 s1=ses.load(Student1.class,id);
        System.out.println("Student Name:"+s1.getStudentName());

        List<Course1>course1List=s1.getCourse1List();
        System.out.println("============================");
        for (Course1 c:course1List){
            System.out.println(c.getCourseName());
        }
    }
}
