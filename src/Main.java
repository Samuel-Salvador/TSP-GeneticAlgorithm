import entities.Chromosome;
import entities.Population;
import services.Evolution;


public class Main {
    public static void main(String[] args) {


        Population.populateFromFile(100,"./tsp-files/burma14.tsp");


        Population.printRouletteChart();
        Population.evolve();
        Population.printRouletteChart();


    }
}