package inno;

import java.util.*;

public class Account {
    private String ownerName;
    private List<Currency> listCurrency = new ArrayList<>();
    private List<Account> oldAccount = new ArrayList<>();

    public Account(String ownerNameIn)
    {
        if (ownerNameIn.isEmpty()) {
            throw new NullPointerException();
        }
        Currency tmpCur = new Currency(CodeCur.RUB,0);
        ownerName = ownerNameIn;
        listCurrency.add(tmpCur);
    }

    public String getName() {
        return ownerName;
    }

    public void setName(String ownerNameIn) {
        if (ownerNameIn.isEmpty()) {
            throw new NullPointerException();
        }
        this.addToOld();
        this.ownerName = ownerNameIn;
    }

    public List<Currency> getlistCurrency() {
        return listCurrency;
    }

    public void setCurrency(Currency currencyIn) {

        for (Currency tmpCur:this.listCurrency){
            if (tmpCur.getCodeCur() == currencyIn.getCodeCur()){
                this.addToOld();
                tmpCur.setCountCur(currencyIn.getCountCur());
                return;
            }
        }
        this.listCurrency.add(currencyIn);
    }

    public void addToOld()  {
        Account copyAccount = new Account(this.ownerName);
        List<Currency> copyListCurrency = new ArrayList<>();
        for (Currency cur: this.listCurrency){
            Currency tmpCur = new Currency(null,null);
            tmpCur.setCountCur(cur.getCountCur());
            tmpCur.setCodeCur(cur.getCodeCur());
            copyListCurrency.add(tmpCur);

        }
        copyAccount.listCurrency = copyListCurrency;
        oldAccount.add(copyAccount);
    }

    public void undo(){
        if (oldAccount.isEmpty()){
            throw new IllegalArgumentException("Невозможно откатить");
        }
        if (this.ownerName != oldAccount.get(oldAccount.size() - 1).ownerName){
            this.ownerName =  oldAccount.get(oldAccount.size() - 1).ownerName;
            oldAccount.remove(oldAccount.size() - 1);
            return;
        }
        this.listCurrency = oldAccount.get(oldAccount.size() - 1).listCurrency;
        oldAccount.remove(oldAccount.size() - 1);

    }

    public void setlistCurrency(List<Currency> listCurrencyIn) {

        this.listCurrency = listCurrencyIn;
    }



}

