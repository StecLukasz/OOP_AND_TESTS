package edu.lust.sda.java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Zasada działania strumienia jest Pantha Rei
 * czyli "wzsytko płynie"
 * czyli nie da się drugi raz wejść do tego samego strumienia
 *
 * Metody działające na stumieniach dzielimy na 3 grupy:
 *
 * 1. Metody tworzące stumień -  musi wystąpić jedna:
 * - stream() na kolekcjach
 * - od() na elementach wyliczonych
 * - Arrays.stream(Object[]) na elementach tabeli
 * - na danych z pliku,....
 * - ... z każdą kolejną Javą pojawia się coś nowego
 *
 * 2. Metody pośrednie - można łączyć, nie musi występować tylko jedna:
 * - map - przekształcająca element strumienia w inny(np. Human -> String, String-> String inny)
 * - flatMap - spłaszczająca elementy z kilku strumieni do jednego stumienia z wszytkimi elementami
 * - filter - filtrująca elementy strumienia wg zadanego kryterium (wszystko co się da jak chcesz)
 * - limit - ograniczająca ilość elementów do dalszego przetwarzania
 * - sorted -  sortująca wg domyślnego albo wskazanego komparatora (compareTo)
 * - distrinct -  wybierająca elementy niepowtarzalne
 * - ...
 *
 * 3. Metody kończące strumień - musi wystąpić jedna:
 * - toArray - tworzy tablicę z elementów strumienia
 * - collect - tworzy kolekcję z elementów strumienia
 * - reduce - zwraca jedną wartość wg zadanego mechanizmu
 * - count -  zwraca ilość elementów
 * - findFirst - zwraca optionala od pierwszego znalezionego obiektu <Oprtional<Object>> (który spełnia wcześniejsze kryteria)
 * - findAny - zwraca optionala od dowolnego znalezionego obiektu(który spełnia wcześniejsze kryteria)
 * - forEach - głównie wyświetla, nic nie zwraca. Wykonuje działanie na elementach strumienia
 * - ...
 * */

public class StreamExercies {
    public static void main(String[] args) {

        //DTO czyli Data Transfer Object
        //czyli klasa pomocnicza która ma przechowywać wycinek większego obiektu
        //lub złożenia obiektów do wykorzystania w jakimś przetwarzaniu lub do
        // przesyłu danych gdzieś(sieć, inna baza danych, na stronę www)

        class HumanDTO{ // ta klasa jet lokalna !!!!!!!!1!!!!2@@@@@@@@@@@@@
            String name;
            String surname;

            public HumanDTO(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }
            public String getHumanData(){
                return surname+ " "+ name;
            }
        }

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

        // klasyczna postać forEach
        // sout(human) zawoła human.toString()
//        for (Human human : people){
//            System.out.println(human);
//        }
//        System.out.println("===============");

        //forEach(dla każdego)
        //System.out::println - odwołanie do metody przez tzw. referencję
        // w naszym przypadku oznacza to:
        //weź każdy kolejny elelemnt kolejkcji peope czyli kolejne obiekty Human z listy people
        // i na każdym z nich wywołaj System.out.println
        // tutaj nie trzeba x, bo jest to wywowyłane automatycznie
        System.out.println("Wywowałnie forEach po ludziach, z wywołaniem przez referencję");
        people.forEach(System.out::println);
        System.out.println("===============");

        //jeszcze postać z lambdą, x podstawia pod siebie każdego Human'a
//        System.out.println("użycie lambdy");
//        people.forEach(x-> System.out.println(x));
//        System.out.println("===============");


        System.out.println("ludzie którzy mają więcej niż 20 lat");
        //wyświetlenie klasyczni
        for (Human human : people) {
            if (human.getAge() > 20) {
                System.out.println(human);
            }
        }

        System.out.println("\n!!!! Teraz STREAM JAVA8, czyli nowy sposób!!!!");
        people.stream()//czyli z kolekcji(albo tablicy) zrób strumien obiektów, żeby pokolei wykonywać na nich operacje
                .filter(x -> x.getAge() > 20) // odsortuj ludzi ktorzy mają wiecej niz 20 lat.
                // to kryterium jest proste, ale możne być bardziej rozbudowane i skomplikowane
                .forEach(System.out::println); // wyświetl to na ekran, ludzi ktorzy mają ponad 20 lat,
        // jest wywoływane na strumieniu a nie na kolejcji jak wcześniej
        System.out.println("====================");

        System.out.println("Ludzie powyżej 20 lat, tylko mężczyźni");
        System.out.println("Pierwszy sposób, na dwa filtry");
        people.stream()
                .filter(x -> x.getAge() > 20)
                .filter(x -> Gender.MAN == x.getGender())
                .forEach(System.out::println);
        System.out.println("====================");
        System.out.println("Drugi sposób");
        people.stream()
                .filter(x -> x.getAge() > 20 && "M".equals(x.getGender().getShortcutPL()))
                .forEach(System.out::println);
        System.out.println("====================");
        System.out.println("Trzeci sposób, żeby to ogarnąć dodając metodę w klasie Human");
        people.stream()
                //te dwa zapisy poniżej, są takie same, oba działają. są TOŻSAME
                .filter(Human::isOver20AndGenderMan)
                .filter(x -> x.isOver20AndGenderMan())
                .forEach(System.out::println);

        System.out.println("====================");
        System.out.println("Ze strumienia/kolejkcji wypisać tylko 2 obiekty");
        people.stream() //to mój sprytny sposób na ominięcie polecenia
                .filter(x -> Gender.WOMAN == x.getGender())
                .filter(x -> x.getAge() < 60)
                .forEach(System.out::println);
        System.out.println("jego sposób");
        int counter = 0;
        for (Human person : people) {
            System.out.println(person);
            counter++;
            if (counter >= 2) {
                break;
            }
        }
        System.out.println("A teraz to samo strumieniowo");
        people.stream()
                .limit(2) // metoda ograniczająca ilość obiektów na wyjściu
                .forEach(System.out::println);

        System.out.println("!!++!! 2 ludzi poniżej 30 lat !!++!!");
        people.stream()
                //limit zafiltuje nam do 2 pierwszych wyników
                //i jeśli podspodem mamy filtorwanie to ono odbywa się na tylko tych 2 elementach
                .filter(x -> x.getAge() < 30)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("===========");
        System.out.println("ludzie posortowani po nazwisku");
        System.out.println("===Klasycznie=====");
        Collections.sort(people);
        people.forEach(System.out::println);
        System.out.println("===Nowy sposób===");
        people.stream()
                .sorted()//używamy domyślnego komparatora do sortowania z klasy Human
                .forEach(System.out::println);

        System.out.println("ludzie posortowani po imionach");
        Collections.sort(people, new HumanComperedByName());// metoda sort korzysta z komparatora zewnętrznego
        people.forEach(System.out::println);

        System.out.println("=============");
        System.out.println("ludzie posortowani po imionach nowym sposobem");
        System.out.println("Opcja 1");
        people.stream()
                .sorted(new HumanComperedByName())
                .forEach(System.out::println);
        System.out.println("Opcja 2 - bez klasy zewnętrznej");
        people.stream()// tworzymy komparator dla tej jednej danej chwili, jesli tylko jeden raz
                .sorted(Comparator.comparing(Human::getAge))
                .forEach(System.out::println);

        System.out.println("+++++++++++++++COS NOWEGO++++++++++++++++++");
        System.out.println("Nowa kolejkcja gdzie bądą tylko mężczyźni");
        List<Human> menOnly = new ArrayList<>();

        System.out.println("Zwykły zapis");
        for (Human human : people) {
            if (human.getGender() == Gender.MAN) {
                menOnly.add(human);
            }
        }
        for (Human human : menOnly) {
            System.out.println(human);
        }
        menOnly.forEach(System.out::println);

        System.out.println("++++++++++zapis tylko kobiet metodą stream++++++++++");
        System.out.println("używanie metody collect()");
        List<Human> onlyWoman = new ArrayList<>();
        onlyWoman = people.stream()
                .filter(x -> Gender.WOMAN == x.getGender()) // sortowanie
                // poniżej filter() mamy już tylko obiekty - kobiety ale to jet dalej strumień
                // i trzeba go przekształcić do postaci wyjściowej( a my chcemy lsitę)
                .sorted(Comparator.comparing(Human::getAge).reversed()) // sortowanie po wieku można dodać.reversed
                .collect(Collectors.toList());
        onlyWoman.forEach(System.out::println);


        System.out.println("===============");
        System.out.println("Wypisać tylko nazwisko i imię");
        System.out.println("+++++++Klasycznie starodawnie++++++++++");
        for (Human a : people) {
            System.out.println(a.getName() + " " + a.getSurname());
        }
        System.out.println("+Pętla forEach");
        people.forEach(x -> System.out.println(x.getSurname() + " " + x.getName()));
        System.out.println("+++Stream");
        System.out.println("+w samym forEach");
        people.stream()
                .forEach(x -> System.out.println(x.getSurname() + " " + x.getName()));
        System.out.println("z przekształceniem obiektu");
        people.stream()
                .map(x->x.getSurname()+" "+x.getName())
                //metoda map() powoduje przekształcenie
                //obiektu w inny w naszym przypadku z oiektu Human robi String
                .forEach(System.out::println);


        System.out.println("=============================================");
        System.out.println("Przepisujemy wszystkich ludzi do HumanDTO");
        List<HumanDTO> humanDTOS = new ArrayList<>();
        for (Human human : people){
            //możemy zrobić tak jak ponizej że do humanDTOs dodajemy obiekt bez nazwy
            // czyli inaczej klasę anonimową
            humanDTOS.add(new HumanDTO(human.getName(), human.getSurname()));
            //ale można zrobić to też tak:
//            HumanDTO localHumanDTO = new HumanDTO(human.getName(), human.getSurname());
//            humanDTOS.add(localHumanDTO);
            }
        System.out.println("Print z DTOS'ów");
        humanDTOS.forEach(x-> System.out.println(x.getHumanData()));
        System.out.println("++++++A teraz to samo ale ze streamem++++++");
        List<HumanDTO> humanDTOSforStream = new ArrayList<>();
        humanDTOSforStream = people.stream()
                //obiekt wejściowy Human, obiekty wyściowy HumanDTO
                .map(x->new HumanDTO(x.getName(), x.getSurname()))
                .collect(Collectors.toList());
        System.out.println("++++++Print z DTOS'ów ze streama++++++");
        humanDTOSforStream.forEach(x-> System.out.println(x.getHumanData()));


        System.out.println("==================");
        System.out.println("Złączyć 2 kolekcje menOnly i OnlyWoman w nową u wypisać zawartość");

        List<Human> newCommonHumankind = new ArrayList<>();
        System.out.println("Klasycznie");
        newCommonHumankind.addAll(onlyWoman);
        newCommonHumankind.addAll(menOnly);
        newCommonHumankind.forEach(System.out::println);
        System.out.println("ze streamem");
        List<Human>newFromStreamHumankind = new ArrayList<>();
        //robimy streama z podanych obiektów czyli menOnly i onlyWoman
        newFromStreamHumankind = Stream.of(menOnly, onlyWoman)
                //po wyjściu ze Stream.of mamy strumień 2-elementowy
                //gdzie elementy strumienia to lista kobiet i lista mężczyzn
                //a metoda flatMap rpbi nam z tych dwóch strumieni jedną mapę/listę
                // czyli nowy strumien ludzi złączonych w jedno.
                .flatMap(a->a.stream())
//                działa tak samo jak tak flatMapa wyżej
//                .flatMap(Collection::stream)

                .collect(Collectors.toList());
        newFromStreamHumankind.forEach(System.out::println);


        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++Reduce - suma lat wszystkich ludzi++++++++++");
        int sumOfAge = people.stream()
                .map(Human::getAge) // na wyjściu jest Stream<Integer>
                //Reduce:
                //1. Zaczynamy od 0
                //2. Dla każdego kolejnego elementu wykonujemy
                //- weź dotychczasową sumę
                //- i dodaj nowy element strumienia
                // zaczyna od 0 i dodaje każdy kolejny element do siebie aż zliczy wszystko
                .reduce(0,(suma, nowy)-> suma+nowy);
        System.out.println("Suma lat wszystich ludzi z tabeli: "+ sumOfAge);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++Reduce - zwracamy 1 String łączący wszystki imiona ludzi++++++++++");
        String namesJoined = people.stream()
                .map(Human::getName)
                .collect(Collectors.joining());
        System.out.println("Złączone imiona to: " + namesJoined);


        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++Reduce - zwracamy 1 String łączący nazwiska z przecinkami++++++++++");
        String surnamesJoinedWitchCommas = people.stream()
                .map(Human::getSurname)
                .collect(Collectors.joining(", "));
        System.out.println("Złączone nazwiska z przecinkami: " +surnamesJoinedWitchCommas );

        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++Reduce - zwracamy 1 String łączący nazwiska z przecinkami i nawiasami przed i po++++++++++");
        String nazwiskaZPrzecinkamiiNawiasami = people.stream()
                .map(Human::getSurname)
//                .collect(Collectors.joining(", ","{","}"));
        .collect(Collectors.joining("), (","{(",")}"));
        System.out.println("Wykonanie metody: "+ nazwiskaZPrzecinkamiiNawiasami);


        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Z listy zrobimy mapę gdzie kluczem będzie imię, a wartością obiekt Human");
        Map<String,Human> mapPeopleByName = people.stream()
                .collect(Collectors.toMap(Human::getName, x->x));
        System.out.println("Klucze: ");
        mapPeopleByName.keySet()
                .forEach(System.out::println);
        System.out.println("Obiekty mapy: ");
        mapPeopleByName.values()
                .forEach(System.out::println);
        System.out.println("Klucz i po d spodem obiekt: ");
        mapPeopleByName.keySet().stream()
                .map(x->x+"\n"+ mapPeopleByName.get(x))
                .forEach(System.out::println);


        Map<String,List<Human>> peopleGroupedBySurname = new HashMap<>();
        //mamy Listę ludzi, romiby z niej mapę gdzie kluczem jest nazwisko i dla każdego nazwiska
        // możemy trzymać listę ludzi
        peopleGroupedBySurname = people.stream()
                .collect(Collectors.groupingBy(Human::getSurname, Collectors.toList()));
        System.out.println(peopleGroupedBySurname);;
        System.out.println("+++++++++++");
        System.out.println("Odzyskujemy tylko Kowalskich do osobnej listy -  jeśli nie ma to ");
        System.out.println("Zwracamy pustą listę");
        System.out.println("Drukowani zostają tylko Kowalscy");
        List<Human> kowalscy = peopleGroupedBySurname.entrySet()
                .stream()
                .filter(mapEntry -> mapEntry.getKey().equals("Kowalski"))
                .map(mapEntry -> mapEntry.getValue())
                //findFirst zwraca OPtiona, jesli nie znajduje obiektu to wykona się orElseGet
                .findFirst()
                //w orElseGt zapewniamy to co ma się wykonać/ podstawić jeśli ne znajdzie się
                // własiciwy obiekt
                .orElseGet(()-> Collections.EMPTY_LIST);
        kowalscy.forEach(System.out::println);












    }
}
