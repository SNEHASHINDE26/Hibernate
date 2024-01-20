package domain;

import javax.persistence.*;

@Entity
@Table(name = "education_info")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "eid_info")
    private int eidInfo;

    @Column(name="ssc")
    private double Ssc;

    @Column(name = "hsc")
    private double Hsc;

    @Column(name = "degree")
    private double Degree;

    public int getEidInfo() {
        return eidInfo;
    }

    public void setEidInfo(int eidInfo) {
        this.eidInfo = eidInfo;
    }

    public double getSsc() {
        return Ssc;
    }

    public void setSsc(double ssc) {
        Ssc = ssc;
    }

    public double getHsc() {
        return Hsc;
    }

    public void setHsc(double hsc) {
        Hsc = hsc;
    }

    public double getDegree() {
        return Degree;
    }

    public void setDegree(double degree) {
        Degree = degree;
    }


}
