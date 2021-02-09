package edu.lust.sda.tests.zadaniadomowe;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static Integer customerNumber = 0;
    private String name;
    private List<Customer> customers;

    private String getNextCustomerInfoNumber(){
        String newCustomerNumber = customerNumber.toString();
        customerNumber++;
        return newCustomerNumber;
    }

    public Bank(String name) {
        this.name = name;
        customers= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public  boolean addCustomer(String name, String surname){
        // dodaje nowego klienta jeśli go nie ma
        Customer customer = new Customer(name, surname);
        if (customers.contains(customer)){
            return false;
        }
        //identyfikator pobieramy z metody żeby się podbił do kolejnej wartości dla następnego klienta
        return customers.add(new Customer(name,surname,getNextCustomerInfoNumber()));
    }

    public boolean eraseCustomer(String name, String surname){
        Customer customerToErase = new Customer(name, surname);
        for (Customer customer : customers){
            if (customer.equals(customerToErase)){
                if (customer.getAccountList().isEmpty()){
                    customers.remove(customer);
                }
                // klient jest ale ma konta to go nie usuwamy
                return false;
            }
        }
        //
        return false;
    }
}
