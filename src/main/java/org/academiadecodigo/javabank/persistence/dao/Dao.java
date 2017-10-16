package org.academiadecodigo.javabank.persistence.dao;

import java.util.List;

public interface Dao {

    List<T> findAll();

    void findById(Integer id);

    void saveOrUpdate(T modelObject);

    void delete (Integer id);



}
