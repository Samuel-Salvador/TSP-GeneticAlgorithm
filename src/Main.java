import entities.Chromosome;
import entities.City;
import entities.Population;
import resources.TSPFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Population.populateFromFile(5,"./tsp-files/burma14.tsp");



        System.out.println(Population.get().getFirst().getFitness());
    }
}