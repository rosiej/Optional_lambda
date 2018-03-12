package model;

public class GraphicCard {
    public GraphicCard(ChipSet chipSet) {
        this.chipSet = chipSet;
    }

    public ChipSet getChipSet() {
        return chipSet;
    }

    private ChipSet chipSet;
}
