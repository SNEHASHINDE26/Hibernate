package Domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name ="abook_info")
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @Column(name = "abook_id")
        private int abookId;

        @Column(name = "abook_name")
        private String abookName;

        @ManyToMany(cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
        @JoinTable(
                name = "author_abook",
                joinColumns = @JoinColumn(name = "abook_ref"),
                inverseJoinColumns = @JoinColumn(name = "author_ref")
        )

        private List<Author>authorList;

        public void addAuthors(Author abook_ref){
            if(authorList==null){
                authorList=new LinkedList<>();
            }
            authorList.add(abook_ref);
        }

    public int getAbookId() {
        return abookId;
    }

    public void setAbookId(int abookId) {
        this.abookId = abookId;
    }

    public String getAbookName() {
        return abookName;
    }

    public void setAbookName(String abookName) {
        this.abookName = abookName;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
