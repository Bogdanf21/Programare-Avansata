package com;

import com.ChocoSolverClass.ChocoSolver;
import com.Models.City;
import com.Models.Continent;
import com.Models.Country;
import com.Repository.CityRepository;
import com.Repository.ContinentRepository;
import com.Repository.CountryRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Main {
    private static final String path = "/home/bogdan/Desktop/concap.csv";

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            City city;
            Country country;
            Continent continent;
            Random rd = new Random();
            while (line != null) {
                city = new City();
                country = new Country();
                continent = new Continent();
                String[] data = line.split(",");

                continent.setName(data[5]);
                new ContinentRepository().create(continent);

                country.setName(data[0]);
                country.setCode(data[4]);
                country.setContinent(continent);
                new CountryRepository().create(country);

                city.setCountry(country);
                city.setName(data[1]);
                city.setCapital(true);
                city.setLatitude(Double.parseDouble(data[2]));
                city.setLongitude(Double.parseDouble(data[3]));
                city.setPopulation(Math.abs(rd.nextInt())%6896987);
                new CityRepository().create(city);

                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ChocoSolver chocoSolver = new ChocoSolver();
        chocoSolver.result(10000,30000000);
    }
}