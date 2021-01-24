package edu.lust.sda.tests.zadaniadomowe;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private  AccountType accountType;
    private BigDecimal balance;
    private String accountNo;

    public Account(String accountNo) {
        this.accountNo = accountNo;
    }

    public Account(AccountType accountType, String accountNo) {
        this.accountType = accountType;
        this.accountNo = accountNo;
        this.balance = BigDecimal.ZERO;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public boolean deposit(BigDecimal someAmount){
        this.balance = this.balance.add(someAmount);
        return true;
    }
    public boolean withdraw(BigDecimal someAmount){
    //Trzeba sprawdzić czy na koncie jest odpowiednia kwota do wypłaty
        if (balance.compareTo(someAmount) < 0){
            balance= balance.subtract(someAmount);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNo.equals(account.accountNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo);
    }


}
