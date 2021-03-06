package edu.lust.sda.tests;

public class BankAccount {
    private String firstname;
    private String lastname;
    private double balance;


    public static final int CHECKINGS=1;
    public static final int SAVINGS=2;

    public int accountType;


    public BankAccount(){
        System.out.println("Konstruktor bezparametrowy");
    }

    public BankAccount(String firstname, String lastname, double balance, int accountType) {
        this();
        System.out.println("Konstruktor z parametrami");
        this.firstname = firstname;
        this.lastname = lastname;
        this.balance = balance;
        this.accountType = accountType;
    }

    public double deposit(double amount, boolean branch){
        if (amount>500 & !branch){
            throw new IllegalArgumentException();
        }
        balance += amount;
        return balance;
    }
    public double withdraw(double amount, boolean branch){
        if (amount>500 && !branch){
            throw new IllegalArgumentException();
        }
        balance -= amount;
        return balance;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public double getBalance() {
        return balance;
    }
    public boolean isSavings(){
        return accountType == SAVINGS;
    }


}
