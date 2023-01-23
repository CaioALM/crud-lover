package com.crud.api.repositories;
import org.springframework.data.jpa.repository.*;

import com.crud.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
