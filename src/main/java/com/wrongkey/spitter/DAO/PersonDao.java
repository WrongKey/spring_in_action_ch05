package com.wrongkey.spitter.DAO;

import com.wrongkey.spitter.Person;

/**
 *@author wrongkey
 *@description
 *@date 2014/11/6
 *@version v1.0
 *
 */
public interface PersonDao {
    void addPerson(Person person);
    void savePerson(Person person);
    Person getPersonById(int id);

}
