package com.example.homework9pa.repositories;

import com.example.homework9pa.entities.City;
import com.example.homework9pa.entities.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class CityRepository extends DataRepository<City,Integer>{

    CityRepository() {
       super(City.class);
    }
    public CityRepository(EntityManager em)
    {super(City.class,em);}

    public void create(City city) {
        this.persist(city);
    }

    public City findByID(String id) {
        return em.find(City.class, id);
    }

    public City findByName(String name)
    {
        return (City) em.createNamedQuery("City.findByName")
                .setParameter("cityName", name)
                .getSingleResult();
    }

    public List<City> findByCountry(Country country) {
        return this.em.createNamedQuery("City.findByCountry")
                .setParameter("country", country)
                .getResultList();
    }


}
