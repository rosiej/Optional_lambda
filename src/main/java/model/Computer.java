package model;

public class Computer {
    public Computer(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    private GraphicCard graphicCard;
}
