package Entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
@Builder
@Table(schema = "Bank")
public class BankAccountEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "number")
    private String number;



    private String cardNumber;

    private Integer amount;

    @Column(name = "balance")
    private Integer balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AccountType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AccountStatus status;

    @Column(name = "availableBalance")
    private BigDecimal availableBalance;
    @Column(name = "actualBalance")
    private BigDecimal actualBalance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public BankAccountEntity() {

    }
}
