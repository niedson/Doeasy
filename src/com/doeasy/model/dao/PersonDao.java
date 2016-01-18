package com.doeasy.model.dao;
import java.util.List; 
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doeasy.model.vo.Person;
 
@Repository
public interface PersonDao extends CrudRepository<Person, Long> {
     
    public List<Person> findBySurname(String surname);
}