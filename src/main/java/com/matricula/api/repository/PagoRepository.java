package com.matricula.api.repository;

import com.matricula.api.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    public List<Pago> findAllByAlumno_Dni(String dni);
}
