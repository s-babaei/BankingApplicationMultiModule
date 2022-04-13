package Entity;


import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "Transaction")
public class TransactionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private String referenceNumber;

    private String transactionId;

    private int type;

    private Date date;

    @Column(nullable=false)
    private long sourceAccountId;

    @Column(nullable=false)
    private long destinationAccountId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private BankAccountEntity account;

    protected TransactionEntity() {
    }

    public  TransactionEntity (int type, double amount, Date date) {
        this.type = type;
        this.amount = BigDecimal.valueOf(amount);
        this.date = date;
    }




}
