package Entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
@Builder
@Table(schema = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "birthday")
    private Date birthday;

    public Integer getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(Integer nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Column(name = "nationalCode",unique = true)
    private Integer nationalCode;
    @Column(name = "userCustomer")
    private Integer userCustomer;
    @Column(name = "phoneNumber")
    private Integer phoneNumber;
    @Column(name = "userState")
    private UserState userState;
    @Column(name = "userType")
    private UserType userType;
    @Column(name = "createDate")
    private Date createDate;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BankAccountEntity> accounts;

    public UserEntity() {

    }

    public int getUserid() {
        return getUserid();
    }

    public Object getNationalCode(Integer nationalCode) {
        return nationalCode;
    }
}
//    @Column(name = "cardNumber")
//    private Integer cardNumber;
//    @Column(name = "amount")
//    private double amount;
//@Column(name = "email")
//    private String email;