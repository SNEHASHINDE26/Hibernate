package Domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name ="course1_info")
public class Course1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    @ManyToMany(cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
               name = "student1_course1",
               joinColumns = @JoinColumn(name = "course1_ref"),
               inverseJoinColumns = @JoinColumn(name = "student1_ref")
    )

    private List<Student1>student1List;

    public void addStudents(Student1 student1Ref){
      if(student1List==null){
          student1List=new LinkedList<>();
      }
      student1List.add(student1Ref);
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student1> getStudent1List() {
        return student1List;
    }

    public void setStudent1List(List<Student1> student1List) {
        this.student1List = student1List;
    }
}

