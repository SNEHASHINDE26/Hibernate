package demo;

import domain.Citizen;
import domain.Passport;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayAllCitizenDetails {
    public static void main(String[]args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Passport.class);
        cfg = cfg.addAnnotatedClass(Citizen.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt=ses.createCriteria(Citizen.class);
        List<Citizen>c1=crt.list();
        for (Citizen c:c1){
            System.out.println(c);
        }
    }
}
