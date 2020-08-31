package com.globallogic.bootcampgl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
