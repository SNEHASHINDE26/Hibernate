package Demo;

import Domain.Author;
import Domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class AcceptAuthorIdAndDisplayBooks {

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

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Author id");
        int id = sc.nextInt();

        Author a1 = ses.load(Author.class, id);
        System.out.println("Author Name:" + a1.getAuthorName());

        List<Book> BookList = a1.getBookList();
        System.out.println("============================");
        for (Book b : BookList) {
            System.out.println(b.getAbookName());
        }
    }
}
