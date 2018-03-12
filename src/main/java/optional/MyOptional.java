package optional;

import model.Address;
import model.Person;

import java.util.Optional;
import java.util.function.Consumer;

class MyConsumer implements Consumer<Address>{

    @Override
    public void accept(Address myaddress) {
        System.out.println(myaddress);
    }
}
public class MyOptional {
    Optional<Person> person = Optional.empty();

    public static void main(String[] args) {

        Address myAddress = new Address("Pachońskiego","Kraków");

        Address nullAddress = null;

        Optional<Address> emptyOptional = Optional.empty();

        Optional<Address> address = Optional.ofNullable(myAddress);

        Optional<Address> nulladdress = Optional.ofNullable(nullAddress);

        System.out.println(address);

        if(emptyOptional.isPresent()){
            System.out.println(emptyOptional.get());
        }

        Consumer<Address> cons = new Consumer<Address>() {
            @Override
            public void accept(Address address) {
                System.out.println(address.getCity()+ " przy ulicy "+address.getStreet()+" -klasa anonimowa");
            }
        };
        cons.accept(myAddress);

        address.ifPresent(address1 -> {
            System.out.println(address1.getCity()+" przy ulicy "+address1.getStreet()+" -lambda");
        });


        address.ifPresent(new MyConsumer());
        address.ifPresent(cons);

    }
}
