package Demo;

import Domain.Course1;
import Domain.Student1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ExistingStudentExistingCourse5 {
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

        Student1 s1=ses.load(Student1.class,2);
        Course1 c1=ses.load(Course1.class,2);
        s1.addCourses(c1);
        tx=ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("Details Inserted Successfully");
    }
}
