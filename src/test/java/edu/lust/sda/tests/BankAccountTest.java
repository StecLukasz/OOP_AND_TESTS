package edu.lust.sda.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount;

   @BeforeEach
    public void setup(){
       bankAccount = new BankAccount("Jan","Kowalski",100,1);
   }
   @Test
    public void testDeposit100(){
       double expected =200;

       double balance = bankAccount.deposit(100,false);

       assertEquals(expected,balance,"Expected value 200 while" + balance+ "was given");
   }




    @Test
    public void testDeposit600InBranch() {
        double expected = 700;

        double balance = bankAccount.deposit(600, true);

        assertEquals(expected, balance, "Expected value 700 while" + balance + "was given");

    }
    @Test
    public void testDeposit600NitInBranch(){
        double expected =700;

        try {
            double balance = bankAccount.deposit(600,false);
            fail("IllegalArgumentException expected but not thrown");
        }catch (IllegalArgumentException e){
            assertEquals(IllegalArgumentException.class, e.getClass());
//            assertThrows(IllegalArgumentException.class, () -> {});      <------ to jest źle, wywala błąd
        }

   }



    @Test
    public void testWithdraw100(){
        double expected =50;

        double balance = bankAccount.withdraw(50,false);

        assertEquals(expected,balance,"Expected value 50 while" + balance + "was given");
    }

}