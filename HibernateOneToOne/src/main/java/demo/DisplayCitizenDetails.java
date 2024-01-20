package demo;

import domain.Citizen;
import domain.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DisplayCitizenDetails {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter citizen Id : ");
        int id=sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Passport.class);
        cfg=cfg.addAnnotatedClass(Citizen.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Citizen c1=ses.load(Citizen.class,id);
        String name=c1.getCitizenName();
        int age=c1.getCitizenAge();

        //get passport reference from citizen class
        Passport ref=c1.getPassportRef();
        String passNo=ref.getPassportNo();
        String country=ref.getCountryName();
        System.out.println(name+"\t\t"+age+"\t\t"+passNo+"\t\t"+country);
    }

}
