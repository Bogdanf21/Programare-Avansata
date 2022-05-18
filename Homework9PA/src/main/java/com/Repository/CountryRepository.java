package com.Repository;

import com.Entity.Continent;
import com.Entity.Country;

public class CountryRepository extends AbstractRepository<Country,Double> {
    public CountryRepository() {
        super(Country.class);
    }

    @Override
    public void create(Country object) {
        if (findByName(object.getName()).isEmpty())
            super.create(object);

        Country tempCountry = findByName(object.getName()).get(0);
        object.setId(tempCountry.getId());
        object.setName(tempCountry.getName());
        object.setCode(tempCountry.getCode());
        object.setContinent(tempCountry.getContinent());
    }
}
