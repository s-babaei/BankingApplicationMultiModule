package Service;

import Entity.TransactionEntity;
import Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

public class TransferService {


    @Autowired
    TransactionRepository transactionRepo;
//
//    @Transactional
//    public synchronized TransactionEntity transactionEntity(long sourceAccountId, long destinationAccountId, BigDecimal transferAmount)
//            throws TransferServiceException {
////        try {
//            // transfer amount must be greater than zero
//            if (transferAmount.compareTo(BigDecimal.ZERO) < 0) {
//                throw new TransferServiceException("Transaction amount must be greater than zero");
//
//            sourceAccountId
//
//
//}
}