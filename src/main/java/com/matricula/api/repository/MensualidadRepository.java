package com.matricula.api.repository;

import com.matricula.api.model.Mensualidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface MensualidadRepository extends JpaRepository<Mensualidad, Long> {
}
