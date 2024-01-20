package Demo;

import Domain.Course1;
import Domain.Student1;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllCoursesAlongWithCountOfEnrollesStudent9 {
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

        Criteria crt=ses.createCriteria(Course1.class);
        List<Course1>course1List=crt.list();
        for(Course1 c:course1List){
            System.out.println("Course Name : "+c.getCourseName());
            List<Student1>student1List=c.getStudent1List();
            System.out.println("Total No Of Student Are "+student1List.size());
            System.out.println("=============================");
        }

    }
}
