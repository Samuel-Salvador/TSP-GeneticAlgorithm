import entities.Chromosome;
import entities.Population;


public class Main {
    public static void main(String[] args) {


        Population.populateFromFile(10,"./tsp-files/burma14.tsp");

        Population.printRouletteChart();

        for(Chromosome chr : Population.selectChromosome(2)){
            System.out.print(chr.getDistanceTraveled() + " - " +chr.getStandOutPercent()+"\n");
        }
    }
}