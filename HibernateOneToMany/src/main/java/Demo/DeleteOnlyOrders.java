package Demo;

import Domain.Customer;
import Domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteOnlyOrders {
    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Order Id : ");
        int id = sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Customer.class);
        cfg = cfg.addAnnotatedClass(Order.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Order o1=ses.load(Order.class,id);
        tx=ses.beginTransaction();
        ses.delete(o1);
        tx.commit();
        System.out.println("DELETED SUCCESSFULLY");
    }
}
