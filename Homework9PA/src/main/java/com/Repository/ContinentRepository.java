package com.Repository;

import com.Entity.Continent;

public class ContinentRepository extends AbstractRepository<Continent,Double> {
    public ContinentRepository() {
        super(Continent.class);
    }

    @Override
    public void create(Continent object) {
        if (findByName(object.getName()).isEmpty())
            super.create(object);
        Continent tempContinent = new Continent();
        tempContinent=findByName(object.getName()).get(0);
        object.setId(tempContinent.getId());
        object.setName(tempContinent.getName());
    }
}
