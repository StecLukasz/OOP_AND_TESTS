package edu.lust.sda.java8.lambdas;
/**
 * Jak klasa implementuje inerfejs ma w nazwie Impl
 * albo coś poedobnego to znaczy że nie ma dla niej dobrej
 * nazwy albo może interfejs jest niepotrzebny
 * */
public class StringAddingImpl implements StringAdding{

    @Override
    public String add(String arg1, String arg2) {
        return null;
    }

    /**
     *możemy ale nie musimy przykrywać tej metody
     * bo ma postać domyślną w interfejsie
     * */
    @Override
    public void someOtherMethodWithBody() {

        System.out.println("Metoda przykryta z klasy");
    }
}
