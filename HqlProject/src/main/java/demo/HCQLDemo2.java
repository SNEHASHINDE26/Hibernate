package demo;

import domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class HCQLDemo2 {
    public static void main(String[]args){


        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        //fetch first 3 records from database table.
        Criteria crt1=ses.createCriteria(Product.class);
        crt1.setMaxResults(3);
        List<Product>productList=crt1.list();
        for(Product p:productList){
            System.out.println(p);
        }
        System.out.println("==============================1");
        //exclude first 3 records
        Criteria crt2=ses.createCriteria(Product.class);
        crt2.setFirstResult(3);
        List<Product>list1=crt2.list();
        for(Product p:list1){
            System.out.println(p);
        }
        System.out.println("===============================2");
        //display product names of first 2 products
        Criteria crt3=ses.createCriteria(Product.class);
        crt3.setMaxResults(2);
        crt3.setProjection(Projections.property("productName"));
        //execute Criteria
        List<String>names=crt3.list();
        for(String s:names){
            System.out.println(s);
        }
        System.out.println("==================================3");
        Criteria crt4=ses.createCriteria(Product.class);
        crt4.add(Restrictions.lt("productPrice",40000.0));
        List<Product>list3=crt4.list();
        for (Product p:list3){
            System.out.println(p);
        }
        System.out.println("==================================4");
        //display products having price between 1000 and 5000
        Criteria crt5=ses.createCriteria(Product.class);
        crt5.add(Restrictions.between("productPrice",1000.0,2000.0));
        List<Product>list4=crt5.list();
        for (Product p:list4){
            System.out.println(p);
        }
        System.out.println("=====================================5");
        //display all the products from electronics
        Criteria crt6=ses.createCriteria(Product.class);
        crt6.add(Restrictions.eq("productCategory","ELECTRONICS"));
        List<Product>list5=crt6.list();
        for(Product p:list5) {
            System.out.println(p);
        }
        System.out.println("=============================6");
        //display products whose name starts with 'L'
        Criteria crt7=ses.createCriteria(Product.class);
        crt7.add(Restrictions.like("productName","L%"));
        List<Product>list6=crt7.list();
        for(Product p:list6) {
            System.out.println(p);
        }
        System.out.println("============================7");
       //display all products from gadgets category having price


    }
}
