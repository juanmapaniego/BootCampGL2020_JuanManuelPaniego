package com.globallogic.bootcampgl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.entity.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
	List<Orden> findByIdSucursal(Long idSucursal);

}
