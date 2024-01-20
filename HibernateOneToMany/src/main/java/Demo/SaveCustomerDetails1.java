package Demo;

import Domain.Customer;
import Domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveCustomerDetails1 {
    public static void main(String[]args) {

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

        //object of customer
        Customer c1 = new Customer();
        c1.setCustomerName("Pooja");
        c1.setCustomerEmail("p@gmail.com");

        Customer c2 = new Customer();
        c2.setCustomerName("Rohini");
        c2.setCustomerEmail("r@gmail.com");

        //objects of orders
        Order ord1=new Order();
        ord1.setOrderNo("ORD1003");

        Order ord2=new Order();
        ord2.setOrderNo("ORD1004");

        Order ord3=new Order();
        ord3.setOrderNo("ORD1005");

        c1.addOrder(ord1);
        c1.addOrder(ord2);
        c1.addOrder(ord3);

        tx=ses.beginTransaction();
        ses.save(c1);
        ses.save(c2);
        ses.save(ord1);
        ses.save(ord2);
        ses.save(ord3);
        tx.commit();

        System.out.println("Details Inserted Successfully");
    }
}
