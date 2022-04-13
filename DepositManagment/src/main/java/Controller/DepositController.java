package Controller;

import Entity.BankAccountEntity;

import Service.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class DepositController {
 /*   @Autowired
DepositService depositService;

    @PostMapping("/add")
    @ResponseBody
    public void add(@RequestBody BankAccountEntity item) {

        depositService.save(item);
    }*/
 @Autowired
 Deposit deposit;


    @GetMapping("/user/{userid}")
    private BankAccountEntity getLatBalance(@PathVariable("userid") int userid) {
        return deposit.getUsersById(userid);
    }




}
