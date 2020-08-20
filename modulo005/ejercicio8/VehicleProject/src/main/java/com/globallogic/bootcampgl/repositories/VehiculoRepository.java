package com.globallogic.bootcampgl.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.model.Vehiculo;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Long> {

}
