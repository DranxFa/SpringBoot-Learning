package com.home.proyecto_ruta.repository;

import com.home.proyecto_ruta.entity.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenoRepository extends JpaRepository<Dueno, Long> {
}
