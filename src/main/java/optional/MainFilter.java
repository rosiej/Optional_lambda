package optional;

import model.Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainFilter {
    public static void main(String[] args) {

        Person person1 = new Person("Mateusz", "Rosiejka", 28, 189);
        Person person2 = new Person("Kasia", "Szczurek", 28, 168);
        Person person3 = new Person("Maciek", "Duro", 27, 180);
        Person person4 = new Person("Paulina", "Niedzielska", 24, 165);
        Person nullPerson1 = null;
        Person nullPerson2 = null;

        List<Person> personList = new ArrayList<>();

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        Optional<Person> maybePerson1 = Optional.of(person1);
        // OPTIONALE RATUJA NAS PRZED NULEM, tutaj jesli obiekt nie przejdzie warunkow to zwroci nam optional empty ale nie null
        maybePerson1.filter(person -> person.getAge() >= 18)                // metoda filter zwraca obiekt ktory jest przekazany
                .filter(person -> person.getHeight() >= 170)               //jesli spelnia jakies warunki ktore okreslimy, jesli nie, zwraca empty
                .ifPresent(person -> System.out.println("osoba o imieniu; " + person.getName() + " jest pelnoletnia i ma powyzej 170 cm wzrostu"));


        for (int i = 0; i < personList.size(); i++) {
            Optional<Person> maybeIsOk = Optional.of(personList.get(i));
            maybeIsOk.filter(person -> person.getAge() <= 27)
                    .filter(person -> person.getHeight() < 168)
                    .ifPresent(person -> System.out.println(person.getName()));
        }

        personList.forEach(person -> {
            Optional<Person> maybeIsOk = Optional.of(person);                       // doklatnie to samo co wyzje ale zrobione na .forEach zamiast for i
            maybeIsOk.filter(per -> per.getAge() <= 27)
                    .filter(per -> per.getHeight() < 168)
                    .ifPresent(per -> System.out.println(per.getName()));
        });

        List<Person> newList = personList.stream().filter(person -> person.getHeight() > 180)  // stream() robi z listy strumieni i mozna na nim uzywac metod
                .filter(person -> person.getAge() == 28).collect(Collectors.toList());          // troche jak w optional, potem trzeba ten strumien zapisac do listy z powrotem
                                                                                                // ale nie zmienia tej samej listy wiec na poczatku tworze nowa i do niej zapisuje
       newList.forEach(person -> System.out.println(person.getName()));                         // <-- wydrukowany wynik
    }
}
