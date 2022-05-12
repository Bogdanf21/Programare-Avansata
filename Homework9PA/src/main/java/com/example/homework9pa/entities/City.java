package com.example.homework9pa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "City.findAll",
                query = "select e from City e order by e.name"),
        @NamedQuery(name = "City.findByCountry",
                query = "select e from City e where e.country = :country"),
        @NamedQuery(name = "City.findByName", query = "select e from City e where e.name = :cityName")
})
public class City extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "capital")
    private Boolean capital;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "population")
    private Integer population;


}