package domain;

import javax.persistence.*;
@Entity
@Table(name ="student_info")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name="student_contact")
    private String studentContact;

    @OneToOne(cascade = CascadeType.ALL)

    @JoinColumn(name="eid_info")
    private Education eidInfo;

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

    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public Education getEidInfo() {
        return eidInfo;
    }

    public void setEidInfo(Education eidInfo) {
        this.eidInfo = eidInfo;
    }

    @Override
    public String toString() {
        return studentId +"\t\t"+ studentName +"\t\t"+ studentContact +"\t\t"+ eidInfo ;
    }
}
