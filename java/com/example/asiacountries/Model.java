package com.example.asiacountries;

import java.util.ArrayList;
import java.util.List;

public class Model {


    String name;
    String flag;
    String capital;
    String region;
    String subregion;
    String population;
    ArrayList<String> borders;

    public Model(String name,String flag, String capital, String region, String subregion, String population, ArrayList<String> borders) {
        this.name = name;
        this.flag = flag;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.borders = borders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag=flag;
    }
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }



    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubRegion() {
        return subregion;
    }

    public void setSubRegion(String subregion) {
        this.subregion = subregion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public ArrayList<String> getBorder() {
        return borders;
    }

    public void setBorder(ArrayList<String> borders) {
        this.borders = borders;
    }


}
