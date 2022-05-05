package com.example.homework9pa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("hello world");

    }

    public static void testJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Continent continent = new Continent("Europe");
        em.persist(continent);
        Continent c = (Continent)em.createQuery(
                        "select e from Continent e where e.name='Europe'")
                .getSingleResult();
        c.setName("Africa");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
