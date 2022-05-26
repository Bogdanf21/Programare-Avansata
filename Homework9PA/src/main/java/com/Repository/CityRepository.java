package com.Repository;

import com.Models.City;

public class CityRepository extends AbstractRepository<City,Double>{

    public CityRepository() {
        super(City.class);
    }

    @Override
    public void create(City object) {
        if (!object.getName().equals("N/A")) {
            if (findByName(object.getName()).isEmpty())
                super.create(object);
            else {
                City tempCity = findByName(object.getName()).get(0);
                object.setId(tempCity.getId());
                object.setName(tempCity.getName());
                object.setCountry(tempCity.getCountry());
                object.setCapital(tempCity.getCapital());
                object.setLatitude(tempCity.getLatitude());
                object.setLongitude(tempCity.getLongitude());
                object.setPopulation(tempCity.getPopulation());
            }
        }
    }


}
