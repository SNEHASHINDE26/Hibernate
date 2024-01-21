package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class UpdatePriceFromCategory {
    public static void main(String[]args){

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction txt;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Product you have to update the price");
        String cat=sc.next();
        System.out.println("Enter the updated price");
        double price=sc.nextDouble();

        txt=ses.beginTransaction();
        //HQL to display all the object of product class.
        Query q=ses.createQuery("Update Product p set p.productPrice='"+price+"'"+cat+"'");
        int count=q.executeUpdate();
        txt.commit();
            System.out.println(+count+"record Update Successfully");


    }
}
