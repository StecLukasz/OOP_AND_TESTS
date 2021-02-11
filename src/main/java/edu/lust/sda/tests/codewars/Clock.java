package edu.lust.sda.tests.codewars;

public class Clock
{
    public static int Past(int h, int m, int s)
    {
        //Happy Coding! ^_^
        int time=0;
        int time1=0;
        int time2=0;
        int time3=0;
        if (h<=23){
            time1=h*3600;
        }
        if (m<=60){
            time2=60*m;
        }
        if (s<=60){
            time3=s;
        }
        time=time1+time2+time3;

        return time*1000;
    }
}
