package com.example.homework9pa;

import com.example.homework9pa.entities.City;
import com.example.homework9pa.entities.Continent;
import com.example.homework9pa.entities.Country;
import com.example.homework9pa.repositories.CityRepository;
import com.example.homework9pa.repositories.ContinentRepository;
import com.example.homework9pa.repositories.CountryRepository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        insertData();
    }

    public static void testJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Continent continent = new Continent();
        continent.setName("Europe");
        em.persist(continent);
        Continent c = (Continent) em.createQuery(
                        "select e from Continent e where e.name='Europe'")
                .getSingleResult();
        c.setName("Africa");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void insertData() {
        Random random = new Random();

        File file = new File("/home/bogdan/Desktop/concap.csv");
        String s;
        List<String[]> data = new ArrayList<>();

        try {
//the file to be opened for reading
            FileInputStream fis = new FileInputStream("/home/bogdan/Desktop/concap.csv");
            Scanner sc = new Scanner(fis);    //file to be scanned
sc.nextLine();
//returns true if there is another line to read
            while (sc.hasNextLine()) {
                s = sc.nextLine();
                data.add(s.split(","));
                System.out.println(s);
            }
            sc.close();     //closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }

        // CONTINENTS

        ContinentRepository continentRepository = new ContinentRepository();
        CountryRepository countryRepository = new CountryRepository(continentRepository.getEm());
        CityRepository cityRepository = new CityRepository(continentRepository.getEm());

        EntityManager entityManager = continentRepository.getEm();




        data.stream().forEach(instance -> {
            entityManager.getTransaction().begin();
            boolean newContinent = false;
            boolean newCountry = false;
            boolean newCity = false;
            Continent continent;
            Country country;
            City city;



            String countryName = instance[0];
            String capitalName = instance[1];
            Double capitalLatitude = Double.parseDouble(instance[2]);
            Double capitalLongitude = Double.parseDouble(instance[3]);
            String countryCode = instance[4];
            String continentName = instance[5];

            //CONTINENT
            continent = continentRepository.findByName(continentName);
            if(continent == null) {
                continent = new Continent();
                continentRepository.persist(continent);
                entityManager.getTransaction().begin();
            }
            //COUNTRY
            country = countryRepository.findByName(countryName);
                if(country == null)
                {
                    country = new Country();
                    country.setName(countryName);
                    country.setContinent(continent);
                    country.setCode(countryCode);
                    countryRepository.persist(country);
                    entityManager.getTransaction().begin();
                }
                continent.getCountries().add(country);
                entityManager.getTransaction().commit();
                entityManager.getTransaction().begin();
                //CITY;
            city= cityRepository.findByName(capitalName);
                if(city == null)
                {
                    city = new City();
                    city.setName(capitalName);
                    city.setLatitude(capitalLatitude);
                    city.setLongitude(capitalLongitude);
                    city.setCountry(country);
                    city.setCapital(true);
                    city.setPopulation(  random.nextInt(100,1000000));
                    cityRepository.persist(city);
                    entityManager.getTransaction().begin();
                }
                country.getCities().add(city);

             entityManager.getTransaction().commit();

        });

        entityManager.close();
    }
}

