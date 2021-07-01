package com.matricula.api.controller;

import com.matricula.api.model.Alumno;
import com.matricula.api.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    public ResponseEntity<?> allAlumnos(){
        List<Alumno> list = service.getAll();
        if (list.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Hay Alumnos Registrados");
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<?> findByNombreOrApellido(@RequestParam String dato){
        List<Alumno> find = service.findByNombreOrApellido(dato, dato);
        return ResponseEntity.status(HttpStatus.OK).body(find);
    }

    @PostMapping
    public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
        if (!service.getById(id)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe el alumno.");
        return ResponseEntity.status(HttpStatus.OK).body(service.update(alumno, id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> changeStatusAlumno(@PathVariable Long id) {
        if (!service.getById(id)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe el alumno.");
        return ResponseEntity.status(HttpStatus.OK).body(service.changeStatus(id));
    }
}
