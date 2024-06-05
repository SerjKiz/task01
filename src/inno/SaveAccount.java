package inno;

import java.util.ArrayList;
import java.util.List;

public class SaveAccount {
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void copyAccount(Account accIn) {
        Account tmpAcc = new Account(accIn.getName());
        List<Currency> tmpListCur = new ArrayList<>();
        for (Currency cur:accIn.getlistCurrency()){
            Currency tmpCur = new Currency(null,null);
            tmpCur.setCountCur(cur.getCountCur());
            tmpCur.setCodeCur(cur.getCodeCur());
            tmpListCur.add(tmpCur);
        }
        tmpAcc.setlistCurrency(tmpListCur);
        this.account = tmpAcc;

    }

    public void restoreAccount(Account accIn) {
        accIn.setName(this.account.getName());
        List<Currency> tmpListCur = new ArrayList<>();
        for (Currency cur:this.account.getlistCurrency()){
            Currency tmpCur = new Currency(null,null);
            tmpCur.setCountCur(cur.getCountCur());
            tmpCur.setCodeCur(cur.getCodeCur());
            tmpListCur.add(tmpCur);
        }
        accIn.setlistCurrency(tmpListCur);
    }

}
