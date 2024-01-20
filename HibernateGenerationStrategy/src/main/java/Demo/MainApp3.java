package Demo;

import Domain.BookData3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainApp3 {
        public static void main(String[]args){
            Scanner sc1=new Scanner(System.in);
            System.out.println("Enter book name:");
            String name= sc1.next();
            System.out.println("Enter book price:");
            double price=sc1.nextDouble();

            Configuration cfg;
            SessionFactory factory;
            Session ses;
            Transaction tx;

            cfg=new Configuration();
            cfg=cfg.configure();
            cfg=cfg.addAnnotatedClass(BookData3.class);
            factory=cfg.buildSessionFactory();
            ses=factory.openSession();

            BookData3 b3=new BookData3();
            b3.setBookName(name);
            b3.setBookPrice(price);

            tx=ses.beginTransaction();
            ses.save(b3);
            tx.commit();
            System.out.println("Book Inserted Successfully");

        }
    }

