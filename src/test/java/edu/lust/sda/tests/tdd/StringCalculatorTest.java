package edu.lust.sda.tests.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {


    StringCalculator calculator;
    @BeforeEach
    public void  setup(){
        calculator = new StringCalculator();
    }
    // if "" passed, return 0

    @Test
    public void testEmptyStringPassed(){
        String value = "";

        int result = calculator.add(value);

        //JUNIT assertion
        assertEquals(0,result,"Expected 0 when passing empty string");

        //ASSERTJ assertions
        assertThat(result).as("Expected 0 when passing empty string").isEqualTo(0);

    }
    @Test
    public void testOneNumberPassed(){
        int expected =3;
        String check ="3";

        int result = calculator.add(check);

        assertThat(result).as("When passing 3, expected 3 on output").isEqualTo(3);

    }

    @Test
    public void testTwoNumbersPassed(){
        int expected = 5;
        String check = "2,3";

        int result = calculator.add(check);

        assertThat(result).as("Expected sum of 2 and 3").isEqualTo(expected);

    }




}