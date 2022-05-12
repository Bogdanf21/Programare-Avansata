package com.example.homework9pa.repositories;

import com.example.homework9pa.entities.City;
import com.example.homework9pa.entities.Country;

import javax.persistence.EntityManager;
import java.util.List;

public class CountryRepository extends DataRepository<Country,Integer>{

    CountryRepository()
    {
        super(Country.class);
    }
    public CountryRepository(EntityManager em)
    {
        super(Country.class, em);
    }


    public Country findByName(String name)
    {
        try {
            return (Country) em.createNamedQuery("Country.findByName")
                    .setParameter("countryName", name)
                    .getSingleResult();
        }
        catch(Exception e){
            System.out.println("No such country found :" + name);
    }
        return null;

    }
}
