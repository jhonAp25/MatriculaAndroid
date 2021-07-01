package com.matricula.api.controller;

import com.matricula.api.model.Grado;
import com.matricula.api.service.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grados")
public class GradoController {

    @Autowired
    private GradoService service;

    @GetMapping
    public ResponseEntity<?> allGrados(){
        List<Grado> list = service.getAll();
        if (list.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Grados.");
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping
    public ResponseEntity<?> createGrado(@RequestBody Grado grado){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(grado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGrado(@RequestBody Grado grado, @PathVariable Long id){
        if (!service.getById(id)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe el grado.");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(grado, id));
    }
}
