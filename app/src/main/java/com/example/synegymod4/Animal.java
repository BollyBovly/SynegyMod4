package com.example.synegymod4;

public class Animal {
    private String name;
    private String animalDiscription;
    private int animalResource;
    private String populationSize;

    public Animal(String name, String animalDiscription, int animalResource, String populationSize) {
        this.name = name;
        this.animalDiscription = animalDiscription;
        this.animalResource = animalResource;
        this.populationSize = populationSize;
    }

    public String getName() {
        return name;
    }

    public String getAnimalDiscription() {
        return animalDiscription;
    }

    public int getAnimalResource() {
        return animalResource;
    }

    public String getPopulationSize() {
        return populationSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnimalDiscription(String animalDiscription) {
        this.animalDiscription = animalDiscription;
    }

    public void setAnimalResource(int animalResource) {
        this.animalResource = animalResource;
    }

    public void setPopulationSize(String populationSize) {
        this.populationSize = populationSize;
    }
}
