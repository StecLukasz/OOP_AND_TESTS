package edu.lust.sda.java8.lambdas;

public class LambdaSamples {
    public static void main(String[] args) {
        /**
         * Lambda (wyrażenie lambda lub funkcja lambda)
         * postać() ->{}
         * gdzie
         * () -  moze ale nie musi zawierać parametry
         * -> operator pomiędzy parametrami a kodem do wykonania
         * {} - zawierają kod do wykonania, czasem kod można zapuisać bez tych klamr
         *
        * */

        String first = "aaa";
        String second = "bbb";

        /**
         * robimy implementację interdejsu StringAdding
         * wyrażenie poniżej odnosi się do metody abstrakcyjnej
         * z interfejsu
         * */

        StringAdding adding = (a, b) -> {return a + b;};

        //określone typy parametrów
        StringAdding addingOneSign = (String a, String b)-> {return a.substring(0,1)+ " "+ b.substring(0,1);};
        //określone typy parametrów ale brak return i średnika na końcu
        StringAdding addingOneSignReturn = (String a, String b)-> a.substring(0,1)+ " "+ b.substring(0,1);

        System.out.println("================");
        System.out.println(adding.add(first,second));
        System.out.println("================");
        System.out.println(addingOneSign.add(first,second));
        System.out.println("================");
        System.out.println(addingOneSignReturn.add(first,second));
        System.out.println("================");


        // to wyżej i niżej to jest to samo, tylko wyżej jest skrótem
        StringAdding anotherAdding = new StringAdding() {
            @Override
            public String add(String arg1, String arg2) {
                return arg1+arg2;
            }
        };

        //wątek przed powstaniem Java 8
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Doing some mutlithreading stuff");
            }
        });
        thread.start();

        // Wątki z javy 8

        Thread lambdaThread =  new Thread(()->{
            System.out.println("Lambda style generated thread");
        });
        lambdaThread.start();


    }
}
