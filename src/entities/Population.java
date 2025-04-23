package entities;

import resources.TSPFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Population {

    private static int size;
    private static List<Chromosome> population = new ArrayList<>();

    public static List<Chromosome> get() {
        return population;
    }

    public static void set(List<Chromosome> population) {
        Population.population = population;
    }

    public static void populateFromFile( int size, String fileName ){
        Population.size = size;

        for( int i=0 ; i<size ; i++ ){

            List<City> allCities = TSPFileReader.getCitiesFromFile(fileName);
            Collections.shuffle(allCities);

            Chromosome newChromosome = new Chromosome(allCities);

            population.add(newChromosome);
        }
    }
    public static void print(){
        for(Chromosome chromosome : population){
            chromosome.print();
        }
    }

}
