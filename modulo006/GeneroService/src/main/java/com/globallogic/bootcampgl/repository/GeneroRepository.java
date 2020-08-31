package com.globallogic.bootcampgl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
