package com.example.homework9pa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.decorator.Decorator;
import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,  generator = "id")
    protected Integer id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}