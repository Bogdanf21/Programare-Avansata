package com.example.homework9pa.entities;

import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "continents")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Continent.findByName",
                query = "select c from Continent c where c.name = :continentName")}
)
public class Continent extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(mappedBy = "continent", cascade = CascadeType.PERSIST)
    private Set<Country> countries = new LinkedHashSet<>();


}