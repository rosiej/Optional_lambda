package model;

public class ComputerWithOptional {
    private GraphicCard card;

    public ComputerWithOptional(GraphicCard card){
        this.card = card;
    }

    public GraphicCard getCard() {
        return card;
    }

    public void setCard(GraphicCard card) {
        this.card = card;
    }
}
