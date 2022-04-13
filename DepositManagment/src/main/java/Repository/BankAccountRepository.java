package Repository;

import Entity.BankAccountEntity;
import Service.WithdrawalMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity,Long> {

    Optional<BankAccountEntity> findByNumber(String accountNumber);
    BankAccountEntity find(WithdrawalMethod withdrawalMethod);
    Optional<BankAccountEntity> findById (Long id);
}
