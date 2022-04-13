package Service.Gharz;


import Service.Deposit;
import Service.WithdrawalMethod;

public class GharzDeposit extends Deposit {
    private static final String title = "سپرده قرض الحسنه";

    public GharzDeposit(int balance) {
        super(balance, title);
        WithdrawalMethod[] methods = {WithdrawalMethod.NORMAL, WithdrawalMethod.CARD};
        setWithdrawalMethod(methods);
    }

    @Override
    public WithdrawalMethod[] getAllowedWithdrawalMethods() {
        return getWithdrawalMethod();
    }

//    @Override
//    protected float getAllowedPercent() {
//        return 0.8f;
//    }
//
//    }
}