/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bahri.dao.service;

import com.bahri.dao.domain.Person;
import java.util.List;

/**
 *
 * @author bahrie
 */
public interface PersonService {
    
    public void save(Person person);
    
    public void delete(Person person);
    
    public List<Person> getAll();
    
    public Person getById(Long id);
    
}
