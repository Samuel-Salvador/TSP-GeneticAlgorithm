package services;

import entities.Chromosome;
import entities.City;
import entities.Population;

import java.util.ArrayList;
import java.util.List;

public class Evolution {


    public static Chromosome diminishCO(List<Chromosome> selectedChromosomes){
        int currentIndex = 0;
        int rangeStart = (int)(Math.random() * Population.getCityQuantityPerChromosome());
        int rangeEnd = rangeStart;
        while(rangeEnd <= rangeStart){
            rangeEnd = (int)(Math.random() * Population.getCityQuantityPerChromosome());
        }

        List<City> childCityList = new ArrayList<>(selectedChromosomes.getFirst().getCitySequence().subList(rangeStart, rangeEnd+1));

        while(currentIndex<rangeStart){
            City currentCity = selectedChromosomes.getLast().getCitySequence().get(currentIndex);

            if(!childCityList.contains(currentCity)){
                childCityList.addFirst(selectedChromosomes.getLast().getCitySequence().get(currentIndex));
            }
            currentIndex++;
        }
        addIfNotPresent(selectedChromosomes.getLast(),childCityList);

       return new Chromosome(childCityList);
    }

    public static List<List<Chromosome>> preserveCO(List<Chromosome> selectedChromosomes){
        int breach = (int)(Math.random() * Population.getCityQuantityPerChromosome());

        List<City> childOneCitySequence = new ArrayList<>(selectedChromosomes.getFirst().getCitySequence().subList(0, breach+1));
        List<City> childTwoCitySequence = new ArrayList<>(selectedChromosomes.getLast().getCitySequence().subList(0, breach+1));

        addIfNotPresent(selectedChromosomes.getLast(),childOneCitySequence);
        addIfNotPresent(selectedChromosomes.getFirst(),childTwoCitySequence);

        Chromosome childOne = new Chromosome(childOneCitySequence);
        Chromosome childTwo = new Chromosome(childTwoCitySequence);
        List<Chromosome> childrenList = new ArrayList<>();
        childrenList.add(childOne);
        childrenList.add(childTwo);

        List<List<Chromosome>> evolutionList = new ArrayList<>();
        evolutionList.add(selectedChromosomes);
        evolutionList.add(childrenList);

        return evolutionList;
    }

    private static void addIfNotPresent(Chromosome fromList, List<City> toList){
        int currentIndex = 0;
        while(!(toList.size() == Population.getCityQuantityPerChromosome())){

            City currentCity = fromList.getCitySequence().get(currentIndex);
            if(!toList.contains(currentCity)){
                toList.add(currentCity);
            }
            currentIndex++;
        }
    }
}
