package Demo;

import Domain.Author;
import Domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertAuthorForBook {
    public static void main(String[]args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Author.class);
        cfg = cfg.addAnnotatedClass(Book.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();


        Book b1 = new Book();
        b1.setAbookName("Rich DAD");


        Author a1 = new Author();
        a1.setAuthorName("Robert");


        b1.addAuthors(a1);

        //save objects
        tx = ses.beginTransaction();
        ses.save(b1);
        ses.save(a1);

        tx.commit();
        System.out.println(" Author added Successfully");
    }
}
