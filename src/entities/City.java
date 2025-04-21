package entities;

public class City {

    private String name;
    private Double coordX, coordY;


    public City(String name, Double cordX, Double cordY) {
        this.name = name;
        this.coordX = cordX;
        this.coordY = cordY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCordX() {
        return coordX;
    }

    public void setCordX(Double cordX) {
        this.coordX = cordX;
    }

    public Double getCordY() {
        return coordY;
    }

    public void setCordY(Double cordY) {
        this.coordY = cordY;
    }
}
