package com.matricula.api.controller;

import com.matricula.api.model.Mensualidad;
import com.matricula.api.service.MensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mensualidad")
public class MensualidadController {

    @Autowired
    private MensualidadService service;

    @GetMapping
    public ResponseEntity<?> allMensualidades(){
        List<Mensualidad> list = service.getAll();
        if (list.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Hay Mensualidades Registrados");
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping
    public ResponseEntity<?> addMensualidad(@RequestBody Mensualidad mensualidad){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(mensualidad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMensualidad(@RequestBody Mensualidad mensualidad, @PathVariable Long id){
        if (!service.getById(id)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe la mensualidad.");
        return ResponseEntity.status(HttpStatus.OK).body(service.update(mensualidad, id));
    }
}
