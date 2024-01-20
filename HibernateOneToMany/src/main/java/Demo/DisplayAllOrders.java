package Demo;

import Domain.Customer;
import Domain.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllOrders {
    public static void main(String[]args){

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Customer.class);
        cfg = cfg.addAnnotatedClass(Order.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt=ses.createCriteria(Customer.class);
        List<Customer>customerList=crt.list();
        for (Customer c:customerList){
            System.out.println("NAME :"+c.getCustomerName());
            List<Order>orderList=c.getOrderList();
            System.out.println("ORDER NUMBER : ");
            for (Order o:orderList){
                System.out.println(o.getOrderNo());
            }
            System.out.println("===========================");
        }
    }
}
