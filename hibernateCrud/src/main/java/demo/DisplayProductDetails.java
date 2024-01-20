package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DisplayProductDetails {
    public static void main(String[]args){
        //declare objects
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();

        factory= cfg.buildSessionFactory();

        ses=factory.openSession();

        Product p=ses.load(Product.class,1);
        System.out.println(p.getProductId());
        System.out.println(p.getProductName());
        System.out.println(p.getProductCategory());
        System.out.println(p.getProductPrice());
    }
}
