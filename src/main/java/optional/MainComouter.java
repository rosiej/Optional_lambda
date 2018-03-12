package optional;

import model.ChipSet;
import model.Computer;
import model.ComputerWithOptional;
import model.GraphicCard;

import java.util.Optional;

public class MainComouter {
    public static void main(String[] args) {


        Computer computer1 = new Computer(null);
        Computer computer2 = new Computer(new GraphicCard(null));
        Computer computer3 = new Computer(new GraphicCard(new ChipSet()));
        ComputerWithOptional computer = new ComputerWithOptional(new GraphicCard(new ChipSet()));

        printCompNameLegacy(computer3);
        printCompNameLegacy(computer2);
        printCompNameLegacy(computer1);

        printCompNewShine(computer1);
        printCompNewShine(computer2);
        printCompNewShine(computer3);


    }

    static private void printCompNameLegacy(Computer comp) {
        if (comp != null) {
            if (comp.getGraphicCard() != null) {
                if (comp.getGraphicCard().getChipSet() != null) {
                    System.out.println(comp.getGraphicCard().getChipSet().getVendorName());
                } else return;
            } else return;
        } else return;

    }

    static private void printCompNewShine (Computer comp){
        Optional.ofNullable(comp)
                .map(computer -> computer.getGraphicCard())
                .map(graphicCard -> graphicCard.getChipSet())
                .map(chipSet -> chipSet.getVendorName())
                .ifPresent(s -> System.out.println(s.toUpperCase()));
    }
//
//    static private void printCompWithFlatMap (ComputerWithOptional comp){
//        Optional.ofNullable(comp)
//                .flatMap(comp1 -> comp1.getCard())
//                .map(u -> )
//    }


}


