package com.example.homework9pa.repositories;

import com.example.homework9pa.entities.City;
import com.example.homework9pa.entities.Continent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ContinentRepository extends DataRepository<Continent,Integer>{
    public ContinentRepository() {
       super(Continent.class);
    }
    ContinentRepository(EntityManager em)
    {super(Continent.class,em);}

    public Continent findByName(String name)
    {
        try{
            Continent toBeReturned = (Continent) em.createNamedQuery("Continent.findByName")
                .setParameter("continentName", name)
                .getSingleResult();
            return toBeReturned;
        }
        catch(Exception e){
            System.out.println("Continent not found:" + name );
    }
        return null;
    }
}
