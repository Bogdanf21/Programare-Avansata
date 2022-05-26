package com.Repository;

import com.EntityManagerFactoryController;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository <O,ID extends Serializable> {

    private EntityManager em = EntityManagerFactoryController.getEntityManagerFactory().createEntityManager();
    private final Class<O> type;

    protected AbstractRepository(Class<O> type) {
        this.type = type;
    }

    public void create (O object){
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
    }
    public O findById(ID id)
    {
        return em.find(type,id);
    }
    public List<O> findByName (String name)
    {
        List<O> result = new ArrayList<>();
        String className = type.getSimpleName();
        try {
            result= em.createNamedQuery(className+".findByName").setParameter("name",name).getResultList();
        }
        catch (NoResultException e)
        {
            System.out.println("No "+className+" with name " + name+" found");
        }
        return result;
    }

    public List<O> findByFirstLetter (char letter)
    {
        List<O> result = new ArrayList<>();
        String className = type.getSimpleName();
        try {
            result= em.createNamedQuery(className+".findByFirstLetter").setParameter("letter",letter).getResultList();
        }
        catch (NoResultException e)
        {
            System.out.println("No "+className+" that starts with  " + letter+" found");
        }
        return result;
    }

    public O findByPopulation (int population)
    {
        List<O> result = new ArrayList<>();
        String className = type.getSimpleName();
        try {
            result= em.createNamedQuery(className+".findByPopulation").setParameter("population",population).getResultList();
        }
        catch (NoResultException e)
        {
            System.out.println("No  "+className+" with population " + population +" found.");
        }
        return result.get(0);
    }
}
