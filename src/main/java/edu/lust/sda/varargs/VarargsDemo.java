package edu.lust.sda.varargs;

public class VarargsDemo {
    public static void main(String[] args) {
        VarargsDemo demo = new VarargsDemo();
        System.out.println(demo.sumAllPassedInts());
        System.out.println(demo.sumAllPassedInts(1));
        System.out.println(demo.sumAllPassedInts(3,2,1));


    }
    /**
    * Varargs pozwalają przekazać od 0 do nieokreślonej (wielu) wartości etego samego typu
    * */
    private int sumAllPassedInts(int... values){
        int result=0;

        for (int value : values) {
            result+=value;
        }

        return result;
    }
    /**
     * Varargs musi być ZAWSZE ostatnim parametrem metody
     * */
    private int sumAllPassedOneAlwaysAvailable(int oneVaue, int... followingValues){
        int result = oneVaue;
        for (int followingValue : followingValues) {
            result+=followingValue;
        }
                return result;
    }

    //private int sumAllPassedOneAlwaysAvailable(int... followingValues, int oneValue)// to już nie zadziałą
}
