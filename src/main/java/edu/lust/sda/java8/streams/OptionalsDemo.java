package edu.lust.sda.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalsDemo {
    public static void main(String[] args) {


        List<Human> people = new ArrayList<>();
        // 3 obiekty tworzone pierwszym konstruktorem, gdzie deklarujemy enym
        people.add(new Human("Jan", "Kowalski", 33, Gender.MAN));
        people.add(new Human("Adam", "Nowak", 44, Gender.MAN));
        people.add(new Human("Alicja", "Zioło", 25, Gender.WOMAN));

        // 3 obiekty tworzone drugim konstruktorem gdzie podajemy jedno z pól enuma i korzystamy
        // z metody statycznej do znalezienia własciwego elementy Gender
        people.add(new Human("Marcin", "Kowalski", 18, "M"));
        people.add(new Human("Teresa", "Kowalski", 65, "K"));
        people.add(new Human("Marta", "Fideluk", 17, "K"));

        String findTrump = people.stream()
                .filter(check->"Trump".equalsIgnoreCase(check.getSurname()))
                .map(Human::getSurname)
                .findAny()
                .orElse("Nie znam człowieka");
        System.out.println("Mamy Trumpa?: "+ findTrump);


        Optional<String> findLechu = people.stream()
                .filter(sss->"Lechu".equalsIgnoreCase(sss.getSurname()))
                .map(Human::getSurname)
                .findFirst();

        if (findLechu.isPresent()){
            System.out.println("Lechu? :" + findLechu);
        }else{
            System.out.println("Lechu? Ni ma leszka");
        }
        System.out.println("użycie optional i orElse");
        Human filteredHuman = people.stream()
                .filter(x->"Marcin".equalsIgnoreCase(x.getName()))
                .findFirst()
                .orElse(getDefailtHuman("N","N",0,"M"));
        // jak mamy metodę to orElse jest słabszym rozwiązaniem
        System.out.println("Odnaleziony człowiek: ");
        System.out.println(filteredHuman);

        System.out.println("przy użyciu orElseGet");
        Human anotherFiltered = people.stream()
                .filter(c->c.getName().equals("Marcin"))
                .findFirst()
                //orElseGet, jak znajdzie obiekt czyli marcina, to nie idzie do metody nizej, bo go znalazł wcześniej
                // jak mamy metodę to orElseGet jest preferowane bo zawartość wykona się tylko jeśli bedzie niezbędna
                .orElseGet(()->getDefailtHuman("N","N",0,"M"));
        System.out.println("Drugi odnaleziony człowiek: ");
        System.out.println(anotherFiltered);

    }
    private static Human getDefailtHuman(String name, String surname, int age, String gender){
        System.out.println("Jestem w metodzie dorabiającej domyślnego człowieka");
        return new Human(name, surname, age,gender);
    }
}
