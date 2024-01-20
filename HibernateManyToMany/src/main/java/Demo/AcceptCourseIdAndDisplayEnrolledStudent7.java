package Demo;

import Domain.Course1;
import Domain.Student1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class AcceptCourseIdAndDisplayEnrolledStudent7 {
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
        System.out.println("Enter the courses id");
        int id=sc.nextInt();

        Course1 c1=ses.load(Course1.class,id);

        //display student and courses
        System.out.println("Student Name"+c1.getCourseName());
        List<Student1>student1List=c1.getStudent1List();
        System.out.println("===============================");
        for(Student1 c:student1List){
            System.out.println(c.getStudentName());
        }


    }
}
