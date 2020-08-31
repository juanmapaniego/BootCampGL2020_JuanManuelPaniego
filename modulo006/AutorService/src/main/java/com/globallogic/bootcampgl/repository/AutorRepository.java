package com.globallogic.bootcampgl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
