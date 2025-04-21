import entities.City;
import services.TSPLibrary;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<City> cities = TSPLibrary.getCitiesFromFile("./burma14.tsp");
        for(City city:cities){
            System.out.println(city.getName());
        }
    }
}