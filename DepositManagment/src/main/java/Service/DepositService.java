//package Service;
//
//import Entity.BankAccountEntity;
//import Repository.BankAccountRepository;
//
//import java.util.Scanner;
//
//public class DepositService {
//
//BankAccountRepository bankAccountRepository;
//    private void checkBalanceAmount(Integer balance) {
//        if (balance < 0) {
//            throw new RuntimeException("balance should not be ziro");
//
//        }
//    }
//    public void save(BankAccountEntity item) {
//
//
//
//        checkBalanceAmount(item.getBalance());
//
//        bankAccountRepository.save(item);
//
//
//    }
//}
//
////    static Scanner input = new Scanner(System.in);
////    String name, actype;
////    int accNo, bal, amt;
//
////    int withdraw() {
////        System.out.println("Your Balance=" + bal);
////        System.out.print("Enter amount to withdraw:");
////        amt = input.nextInt();
////        if (bal < amt) {
////            System.out.println("Not sufficient balance.");
////            return 1;
////        }
////        if (amt < 0) {
////            System.out.println("Invalid Amount");
////            return 1;
////        }
////        bal = bal - amt;
////        return 0;
////    }
////
////    void display() {
////        System.out.println("Name:" + name);
////        System.out.println("Account No:" + accNo);
////        System.out.println("Balance:" + bal);
////
////    }
////
