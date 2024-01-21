package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertProduct {
    public static void main(String[]args){
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Product p1=new Product(2, "AC", "ELECTRONICS", 55000.30);

        tx=ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Product Added");

    }
}
