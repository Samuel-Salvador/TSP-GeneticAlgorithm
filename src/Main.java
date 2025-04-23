import entities.Chromosome;
import entities.City;
import entities.Population;
import resources.TSPFileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Population.populateFromFile(5,"./tsp-files/burma14.tsp");

        for(Chromosome chromosome: Population.get()){
            chromosome.print();
            System.out.printf("Fitness = %.4f\n" , chromosome.getFitness());
        }
    }
}