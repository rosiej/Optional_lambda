package optional;

public interface Printable {

    String showName();                  // ten interfejs ma tylko jedna metode niezdefiniowana showName()

    default String showSurname(){       // showSurname() jest zdefiniowany ze slowkiem kluczowym default i dlatego mozna stosowac na nim
        return "Rosiejka";              // lambdy
    }
}

interface Calculable {
    int addArgs(int a, int b);

    default int substrateArgs(int a, int b){
        return a-b;
    }
}

interface CountingLenght {

     int lenghtOfTwoStrings(String a, String b);
}

class PrintablePerson implements Printable{

    @Override
    public String showName() {
        return "Mateusz";
    }
}
class Main {
    public static void main(String[] args) {

        Printable prPerson = new PrintablePerson();

        Printable prPerson2 = new Printable() {  //przyklad klasy anonimowej kiedy potrzebujemy
            @Override                              //tylko jedna instancje jakiejs klasy ktora np implementuje
            public String showName() {             // interfejs, nawet nie musimy jej tworzyc
                return "not Mateusz";
            }

            public String showSurname(){      // ta metoda nie bedzie nigdzie widoczna
                return "not Rosiejka";          // i nie zadziala bo odnosimy sie do instancji wyzej
            }
        };

        System.out.println(prPerson2.showName());

        Runnable run = new Runnable() {          // przyklad z uzyciem interface runnable
            @Override
            public void run() {
                System.out.println("running");
            }
        };

        run.run();

        Runnable run2 = () -> {                     // tak wyglada lambda czyli wlasciewie to to samo co klasa anonimowa
            System.out.println("My first lambda");  // jesli ma tylko jedna instrukcje to mozna napisac cialo bez {}
        };                                          // np = () -> System.out.println("cos tam cos tam");
                                                    // WAZNE lambda jest tylko dla interfejsow z jedna metoda!!!
                                                    // lub taki w ktorym metody maja jakis default a jedna tylko jest abstrrakcyjna
        run2.run();


        Printable myPrintableLambda = () -> {       // lamda dla metody showName() patrz wyzej

            return "Mateusz";                       // W tym wypadku nie musielibysmy używać {} i nawet slowka return
        };

        Calculable calculable = ( a, b) -> a+b;    // przyklad lambdy ktora przyjmuje argumenty, przy wpisywaniu mozemy
                                                    // podac argumenty jako same nazwy w tym wypadku bez int

        System.out.println(calculable.addArgs(4,5));  // wykorzystanie tej motody do wydrukowania wyniku


        CountingLenght count = (a,b) -> {
            int c = a.length()+b.length();
            System.out.println(c);
            return c;
        };

       count.lenghtOfTwoStrings("mateusz","rosiejka");
    }
}

