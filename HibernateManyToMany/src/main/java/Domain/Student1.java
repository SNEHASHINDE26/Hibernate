package Domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name ="student1_info")
public class Student1 {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @Column(name = "student_id")
        private int studentId;

        @Column(name = "student_name")
        private String studentName;

        @ManyToMany(cascade ={CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
        @JoinTable(
                     name = "student1_course1",
                     joinColumns = @JoinColumn(name = "student1_ref"),
                     inverseJoinColumns = @JoinColumn(name = "course1_ref")
        )
        private List<Course1>course1List;

        public void addCourses(Course1 course1Ref){
                if(course1List==null){
                        course1List=new LinkedList<>();
                }
                course1List.add(course1Ref);
        }

        public int getStudentId() {
                return studentId;
        }

        public void setStudentId(int studentId) {
                this.studentId = studentId;
        }

        public String getStudentName() {
                return studentName;
        }

        public void setStudentName(String studentName) {
                this.studentName = studentName;
        }

        public List<Course1> getCourse1List() {
                return course1List;
        }

        public void setCourse1List(List<Course1> course1List) {
                this.course1List = course1List;
        }
}
