package com.example.homework9pa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
@Setter
@Getter
@NamedQuery(name = "Country.findByName", query = "select e from Country e where e.name = :countryName")
public class Country extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "code", length = 50)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "continent_id")
    private Continent continent;

    @OneToMany(mappedBy = "country", cascade = CascadeType.PERSIST)
    private Set<City> cities = new LinkedHashSet<>();


}