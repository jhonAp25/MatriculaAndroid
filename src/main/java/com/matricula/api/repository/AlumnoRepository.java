package com.matricula.api.repository;

import com.matricula.api.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    List<Alumno> findByNombreContainsOrApellidoContains(String n, String a);

    Alumno findByNombre(String n);
}
