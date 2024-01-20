package domain;

import javax.persistence.*;

@Entity
@Table(name ="passport_info")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "passport_id")
    private int passportId;
    @Column(name = "passport_no")
    private String passportNo;
    @Column(name="country")
    private String countryName;

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return passportId +"\t\t"+ passportNo  +"\t\t"+ countryName ;
    }
}
