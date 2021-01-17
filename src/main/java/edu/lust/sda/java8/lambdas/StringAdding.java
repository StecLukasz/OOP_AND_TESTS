package edu.lust.sda.java8.lambdas;

/**
 * Adnotacja ta niżej oznacza interfejs funkcyjny
 * czyli taki który ma dokładnie jedną metodę abstrakcyjną
 *
 * Dopuszczalne są inne metody w inferfejsie ale wtedy musza mieć
 * domyślną implementację (Słowo kluczowe default)
 * */

@FunctionalInterface
public interface StringAdding {
    // jedyna abstrakcyjna metoda w interfejsie funkcyjnym
    String add(String arg1, String arg2);

    //jeśli domołzymy kolejną metodę abstrakcynją to
    //IDE podświetli adnotację

//    void testAnotherMetgod();

    default void someOtherMethodWithBody(){
        System.out.println("This is default method form interface");

    }


}
