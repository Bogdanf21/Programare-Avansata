package com.example.homework9pa.repositories;


import com.example.homework9pa.entities.AbstractEntity;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.crypto.Data;
import java.io.DataOutput;
import java.io.Serializable;
import java.lang.reflect.Type;


@Getter
public abstract class DataRepository
        <T extends AbstractEntity, ID extends Serializable> {
    protected EntityManager em; //create it somehow
    private Class<T> type;

    public DataRepository(Class<T> type){
        this.type = type;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        this.em = emf.createEntityManager();
    }

    public DataRepository(Class<T> type,EntityManager em){
        this.type = type;
        this.em = em;
    }
    public T findById(ID id) {
        return  em.find(this.type,id);
    }
    public boolean persist(T entity) {
        try {
            em.persist(entity);
            commit();
            return true;
        } catch (Exception e) {
            handleException(e);
            rollback();
            return false;
        }
    }

    private void handleException(Exception e) {
    }

    public void commit() {
       this.em.getTransaction().commit();
    }

    public void beginTransaction() {
        this.em.getTransaction().begin();
    }

    private void rollback() {
        this.em.getTransaction().rollback();
    }

}