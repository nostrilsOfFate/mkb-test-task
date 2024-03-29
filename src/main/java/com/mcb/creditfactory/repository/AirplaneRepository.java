package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
    List<Airplane> findAll();
}
