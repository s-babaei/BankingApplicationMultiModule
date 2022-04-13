package Service;

import Entity.BankAccountEntity;
import Entity.UserEntity;
import Repository.BankAccountRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public abstract class Deposit {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    private EntityManager entityManager;


    private String title;
    private int balance;
    private String depositNumber;
//    private Customer customer;
    private Date openDate;
   // private float withdrawalAllowedPercent;
    private WithdrawalMethod[] withdrawalMethod;

    public Deposit(int balance, String title) {
    }

//    public Deposit(int balance, String title){
//        setBalance(balance);
//    }
//
//    public Deposit(String depositNumber, int balance, Customer customer){
//
//    }

//    public void defray(int balance){
//        //..
//    }

//    public abstract WithdrawalMethod[] getAllowedWithdrawalMethods();

   // public void withdrawal(int balance, WithdrawalMethod withdrawalMethod){
      //  validateWithdrawal(balance, withdrawalMethod);
       // withdrawal(balance);
   // }
    public Long withdraw(WithdrawalMethod withdrawalMethod, Integer amount) {





        BankAccountEntity bankAccountEntity = bankAccountRepository.find(withdrawalMethod);
        Integer balance = bankAccountEntity.getBalance();
        if (balance < amount)
            throw new RuntimeException("balnce should not be negetive");
        if (balance.equals(amount)) {
            throw new RuntimeException("balance should not be ziro");
        }

        balance -= amount;
        bankAccountEntity.setBalance(balance);
        bankAccountRepository.save(bankAccountEntity);
        return Long.valueOf(balance);


    }
    public Long deposit(WithdrawalMethod withdrawalMethod, Integer amount) {

      // BankAccountEntity withdrawalMethod = bankAccountRepository.find(WithdrawalMethod.valueOf(bankAccountEntity.getCardNumber()));
        BankAccountEntity bankAccountEntity = bankAccountRepository.find(withdrawalMethod);
       // Integer balance = card.getBalance();
        Integer balance = bankAccountEntity.getBalance();
        balance += amount ;
       bankAccountEntity.setBalance(balance);
        bankAccountRepository.save(bankAccountEntity);
        return Long.valueOf(balance);


    }

    public abstract WithdrawalMethod[] getAllowedWithdrawalMethods();

//    protected void withdrawal(int balance) {
//        setBalance(getBalance() - balance);
//        System.out.println("Withdrawal success");
//    }
public void save(BankAccountEntity item) {



    checkBalanceAmount(item.getBalance());

    bankAccountRepository.save(item);
    listCreateBankAccount();

}

    private void checkBalanceAmount(Integer balance) {
        if (balance < 0) {
            throw new RuntimeException("balance should not be ziro");

        }
    }


    public List<BankAccountEntity> listCreateBankAccount() {
        String sql = "Select new " +  UserEntity.class.getName()
                + "(e.id,e.fullName,e.balance) "
                + " from " +BankAccountEntity.class.getName() + " e ";
        Query query = (Query) entityManager.createQuery(sql,UserEntity.class);
        return query.getResultList();
    }


    public BankAccountEntity getUsersById(int id) {
        return bankAccountRepository.findById((long) id).get();

    }
}

//    protected void validateWithdrawal(int balance, WithdrawalMethod withdrawalMethod){
//        if(balance < 0){
//            throw new RuntimeException("Balance is negative");
//        }
//        if(balance > getBalance()){
//            throw new RuntimeException("Balance is not permitted, Max balance exceeded");
//        }
//        if(balance > getMaxAllowedWithdrawalBalance()){
//            throw new RuntimeException("Balance is not permitted");
//        }
//        if(!isWithdrawalContain(withdrawalMethod)){
//            throw new RuntimeException("Withdrawal method is not permitted");
//        }
//    }

//    private boolean isWithdrawalContain(WithdrawalMethod withdrawalMethod) {
//        for (WithdrawalMethod method : this.withdrawalMethod){
//            if(method.equals(withdrawalMethod)){
//                return true;
//            }
//        }
//        return false;
//    }

//    public int getMaxAllowedWithdrawalBalance(){
//        return (int)(getBalance() * getWithdrawalAllowedPercent());
//    }
//
//    protected float getWithdrawalAllowedPercent(){
//        return this.withdrawalAllowedPercent;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public void setDepositNumber(String depositNumber) {
//        this.depositNumber = depositNumber;
//    }
//
//    public void setBalance(int balance) {
//        this.balance = balance;
//    }
//
//    public void setOpenDate(Date openDate) {
//        this.openDate = openDate;
//    }
//
//    public int getBalance() {
//        return balance;
//    }
//
//    public String getDepositNumber() {
//        return depositNumber;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public Date getOpenDate() {
//        return openDate;
//    }
//
//    public void setWithdrawalAllowedPercent(float withdrawalAllowedPercent) {
//        this.withdrawalAllowedPercent = getAllowedPercent();
//    }
//
//    public abstract WithdrawalMethod[] getAllowedWithdrawalMethods();
//
//    protected abstract float getAllowedPercent();
//
//    public void setWithdrawalMethod(WithdrawalMethod[] withdrawalMethod) {
//        this.withdrawalMethod = withdrawalMethod;
//    }
//
//    public WithdrawalMethod[] getWithdrawalMethod() {
//        return withdrawalMethod;
//    }
//}
