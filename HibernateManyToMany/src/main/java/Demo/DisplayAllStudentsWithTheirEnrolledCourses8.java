package Demo;

import Domain.Course1;
import Domain.Student1;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllStudentsWithTheirEnrolledCourses8 {
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

        Criteria crt=ses.createCriteria((Student1.class));
        List<Student1>student1List=crt.list();
        for(Student1 s:student1List){
            System.out.println("Student Name :"+s.getStudentName());
            List<Course1>course1List=s.getCourse1List();
            System.out.println("Enrolled Courses Are :");
            System.out.println("==========================");
            for(Course1 c:course1List){
                System.out.println(c.getCourseName());
            }
            System.out.println("=============================");

        }
    }
}
