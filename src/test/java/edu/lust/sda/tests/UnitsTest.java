package edu.lust.sda.tests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UnitsTest {

    Units units;

    @BeforeAll // używany rzadziej
    public static void commonSetup(){
        System.out.println("CommonSetup called once per class");
    }

    @BeforeEach // używany częściej
    public  void setup(){   // ustawia nam to że przed każdym testem wykonuje tą metodeę setup !
        System.out.println("Set new object for every test");
        units = new Units();
    }

    @Test
    public void testRemovePairs(){
        //given
        String expected = "ABCDEFG";
        String toCheck = "AABCCDEFFG";
        //when
        String result =  units.removePairs(toCheck);
        //then
        assertEquals(expected,result);
    }

    @Test
    public void testEveyNthChar(){
        char[] expected = new char[]{'a','b'};
        char[] toCheck = new char[]{'l','a','b','a'};

        char[] result = units.eveyNthChar(toCheck,2);

        assertArrayEquals(expected,result);




    }


    @AfterEach // używany częściej
    public void  teardown(){
        System.out.println("After each test");
        units.toString();
    }
    @AfterAll // używany rzadziej, raczej testy ingtegracyjne
    public static void AfterAllTests(){
        System.out.println("After run once after all tests");
    }



}