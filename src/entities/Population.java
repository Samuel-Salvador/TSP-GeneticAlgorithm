package entities;

import resources.TSPFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Population {

    private static int size;
    private static List<Chromosome> population = new ArrayList<>();
    private static double fitnessSum;

    public static List<Chromosome> get() {
        return population;
    }

    public static void set(List<Chromosome> population) {
        Population.population = population;
    }

    public static double getFitnessSum(){
        return fitnessSum;
    }

    public static void setFitnessSum(){
        double fitnessSum = 0.0;

        for(Chromosome chr : population){
            fitnessSum += chr.getFitness();
        }
        Population.fitnessSum = fitnessSum;
    }

    public static void populateFromFile( int size, String fileName ){
        Population.size = size;

        for( int i=0 ; i<size ; i++ ){
            List<City> allCities = TSPFileReader.getCitiesFromFile(fileName);
            Collections.shuffle(allCities);

            Chromosome newChromosome = new Chromosome(allCities);

            population.add(newChromosome);
        }
        setFitnessSum();

        for(Chromosome chr : population){
            chr.setStandOutPercent();
        }
    }

    public static void print(){
        for(Chromosome chr : population){
            chr.print();
        }
    }

    public static void printRouletteChart(){
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.print("Chromosome\t\tDistance\t\tFitness\t\t\t\tfA(x)\n");

        for(int i=0;i<size;i++){
            System.out.printf("%d\t\t\t\t%.2f\t\t\t%.10f\t\t%.2f %%\n",i+1,population.get(i).getDistanceTraveled(),population.get(i).getFitness(),population.get(i).getStandOutPercent());

        }
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");


    }

    public static List<Chromosome> selectChromosome(int quantity){
        List<Chromosome> selectedChromosomes = new ArrayList<>();
        for(int i=0 ; i < quantity ; i++){

            double percentageSeen = 0.0;
            double drawnNumber = (Math.random()*100);

            for (Chromosome chr : population){
                percentageSeen += chr.getStandOutPercent();

                if(percentageSeen >= drawnNumber){

                    if(selectedChromosomes.contains(chr)){
                        i--;

                    }else{
                        selectedChromosomes.add(chr);

                    }
                    break;
                }
            }

        }
        return selectedChromosomes;
    }
}
