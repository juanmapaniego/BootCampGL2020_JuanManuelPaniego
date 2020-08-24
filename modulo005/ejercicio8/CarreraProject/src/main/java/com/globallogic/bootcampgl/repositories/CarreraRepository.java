package com.globallogic.bootcampgl.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.model.Carrera;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {

}
