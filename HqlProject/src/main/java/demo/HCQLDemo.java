package demo;

import domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class HCQLDemo {
    public static void main(String []args){
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        //Fetching details from all the columns.
        //create criteria
        Criteria crt=ses.createCriteria(Product.class);

        List<Product>ProductList=crt.list();
        for(Product p:ProductList){
            System.out.println(p);
        }

        System.out.println("============================");

        //Fetching details from specific columns
        Criteria crt2=ses.createCriteria(Product.class);
        //add requirement details
        crt2.setProjection(Projections.property("productName"));
        //execute criteria
        List<String>names=crt2.list();
        for (String s:names){
            System.out.println(s);
        }

        System.out.println("==============================");

        //fetch details from name and price columns.
        Criteria crt3=ses.createCriteria(Product.class);

        //execute criteria
       // List<Product>productData=crt3.list();
       // for (Product p:productData){
           // System.out.println(p.getProductName()+"\t"+p.getProductPrice());
       // }
                       //OR
        ProjectionList pList=Projections.projectionList();
        pList.add(Projections.property("productName"));
        pList.add(Projections.property("productPrice"));
        //if you want to add some more columns you can add here and also add in sopln(arr[3])
        crt3.setProjection(pList);
        //execute criteria
        List data=crt3.list();
        Iterator itr=data.iterator();
        while (itr.hasNext()){
            Object[]arr=(Object[])itr.next();
            System.out.println(arr[0]+"\t\t"+arr[1]);
        }
    }
}
