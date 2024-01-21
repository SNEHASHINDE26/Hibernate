package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveProductDetails {

    public static  void main(String[]args){
        //declare objects
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        //step-1 --> Activate hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure(); //reads the data from cfg file.

        //step-2--> Establish communication link
        factory= cfg.buildSessionFactory();

        //step-3--> start the session
        ses=factory.openSession();

        //step-4--> Create object of domain class
        Product p1=new Product();
        p1.setProductId(1);
        p1.setProductName("LAPTOP");
        p1.setProductCategory("ELECTRONICS");
        p1.setProductPrice(45000.25);

        //step-5--> Start the transaction
        tx=ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Product Inserted Successfully");
    }
}
