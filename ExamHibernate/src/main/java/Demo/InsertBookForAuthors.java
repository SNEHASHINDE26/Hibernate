package Demo;

import Domain.Author;
import Domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertBookForAuthors {

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


        //create object of abook
        Book b1 = new Book();
        b1.setAbookName("HARRY POTTER");

        //create object of author
        Author a1 = new Author();
        a1.setAuthorName("JK Rowling");

        //add book to author
        a1.addBooks(b1);


        //save objects
        tx = ses.beginTransaction();
        ses.save(a1);
        ses.save(b1);

        tx.commit();
        System.out.println("Book added Successfully");
    }
}
