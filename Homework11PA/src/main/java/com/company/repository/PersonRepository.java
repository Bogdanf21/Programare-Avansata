package com.company.repository;

import com.company.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PersonRepository extends JpaRepository<Person,Long> {

    @Query(value = "SELECT * from persons p ORDER BY p.number_of_friends desc LIMIT :N",nativeQuery = true)
    Set<Person> getMostPopularNPersons(@Param("N") int n);
}
