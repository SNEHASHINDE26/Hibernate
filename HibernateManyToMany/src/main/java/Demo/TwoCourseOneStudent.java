package Demo;

import Domain.Course1;
import Domain.Student1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TwoCourseOneStudent {

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


        //create object of course
        Course1 c1=new Course1();
        c1.setCourseName("J2EE");

        Course1 c2=new Course1();
        c2.setCourseName("HIBERNATE");

        //create object of students
        Student1 s1=new Student1();
        s1.setStudentName("Sneha");

        //add courses to student
        s1.addCourses(c1);
        s1.addCourses(c2);

        //save objects
        tx=ses.beginTransaction();
        ses.save(s1);
        ses.save(c1);
        ses.save(c2);
        tx.commit();
        System.out.println("Courses added Successfully");
    }
}
