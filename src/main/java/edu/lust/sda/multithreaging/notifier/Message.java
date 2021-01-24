package edu.lust.sda.multithreaging.notifier;

import static edu.lust.sda.multithreaging.ThreadColor.*;

public class Message {
    private String messageContent;
    //messageEmpty jest znacznikiem który mówi czy do obiektu klasy Message można aktualnie
    //przekazać nową wiadomość, czy jakaś jest właśnie w trakcie przetwarzania
    private boolean messageEmpty = true;


    //odczytujemy wiadomość
    //synchronized więc może odczytywać tylko 1 wątek na raz
    public synchronized String read(){
        //dopóki nie ma nic do oczytu to czekaj
        //messageEmpty musi zostać ustawione na false w metodzie write()
        while(messageEmpty){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(ANSI_GREEN + "Błąd odczytu wiadomości");
            }
        }
        //jak tutaj doszliśmy to znaczy że messageEmpty jest równe false
        // czyli jest jakaś wiadomość do obsłużenia
        System.out.println(ANSI_GREEN + "Odczytujemy wiadomość: ");
        System.out.println(ANSI_CYAN+messageContent);
        //po odczytaniu wiadomości ustaw znacznik spowrotem na true
        messageEmpty = true;
        //notifyAll powiadamia wszelkie inne wątki że bieżący kończy działanie
        //wselkie inne na których działa metoda wait() mogą próbować działać
        notifyAll();
        //notify zamiast notidyAll powoduje powiadomienie 1 wątku który jest w trakcie wait()
        //i to jest losowy z czekających wątków
        //notify();
        return messageContent;
    }

    //synchronized czyli 1 wątek na raz może tą metodę wykonywać
    public synchronized void write(String newMessage){
        //jeśli znacznik mówi że jest jakaś wiadomość to nie można wpisać nowej
        // i trzeba czekać na notify() lub notifyAll() z innego wątku
        while(!messageEmpty){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(ANSI_BLUE + "Błąd zapisu wiadomości");
            }
        }
        //ktoś zrobił notify/ notifyAll więc wpisujemy nową wiadomość
        System.out.println(ANSI_BLUE+"Nowa wiadomość zapisana");
        System.out.println(ANSI_BLUE+newMessage);
        // ustawiamy znacznik że nowa wiadomość wpisana i należy ją obsłużyć
        messageEmpty=false;
        messageContent=newMessage;
//        powiadamiamy innewątki że metoda write kończy się działanie
        notifyAll();
        /**
         * Cykl życia:
         * 1. Writer wykonuje metodę message.write()
         * - jeśli w massage nie ma innej wiadomości czekające na obsłużenie
         * to zapisuje i powiadamia iinych że skończył
         * - jesli w message jest inna wiadomośc to czeka aż ta poprzednia wiadomość zostanie obsłiżona
         * i wtedy zapisuje i powiadamia innych
         *
         * 2.Reader próbuje wykonać message.read()
         * - jeśli w message nie ma wiadomości do odczytania to czeka aż taka wiadomosć się pojawi
         * - jesli w message jest wiadomosc to ją odczytuje i powiadamia innych że skończył,
         * a do obiektu message moązna wpisać kolejną wiadomość
         * - jak wiadomość ="EOF" to reader kończy wszelkie odczyty
         *
         * */
    }
}
