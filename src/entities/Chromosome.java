package entities;

import java.util.ArrayList;
import java.util.List;

public class Chromosome {

    private List<City> citySequence = new ArrayList<>();
    private double fitness;

    public Chromosome(List<City> citySequence) {
        citySequence.add(citySequence.getFirst());
        this.citySequence = citySequence;
        this.fitness = 1/totalDistanceTraveled();
    }

    public List<City> getCitySequence() {
        return citySequence;
    }

    public void setCitySequence(List<City> citySequence) {
        this.citySequence = citySequence;
    }

    public void print(){
        for(int i=0 ; i<citySequence.size() ; i++){
            if( !( i == citySequence.size()-1 ) ){
                System.out.print(citySequence.get(i).getName() + " - ");
            }else{
                System.out.print(citySequence.get(i).getName());
            }
        }
        System.out.println();
    }


    public double getFitness() {
        return fitness;
    }

    public double totalDistanceTraveled(){
        double distanceTraveled=0.0;
        for (int i=0 ; i<citySequence.size()-1 ; i++){
            distanceTraveled+= Math.sqrt(
                    Math.pow(citySequence.get(i+1).getCordX()-citySequence.get(i).getCordX(),2) +
                            Math.pow(citySequence.get(i+1).getCordY()-citySequence.get(i).getCordY(),2));
        }
        return distanceTraveled;
    }
}
