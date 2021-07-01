package com.matricula.api.controller;

import com.matricula.api.model.Pago;
import com.matricula.api.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pagos")
public class PagoController {

    @Autowired
    private PagoService service;

    @GetMapping
    public ResponseEntity<?> allPagos(){
        List<Pago> list = service.getAll();
        if (list.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Hay Pagos Registrados");
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping(value = "/buscar")
    public ResponseEntity<?> PagoPorDni(String dni){
        //List<Pago> list = service.listadoDni(dni);
       // if (list.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Hay Registro con ese Dni");
        return ResponseEntity.status(HttpStatus.OK).body(service.listadoDni(dni));
    }

    @PostMapping
    public ResponseEntity<?> createPago(@RequestBody Pago pago){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(pago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePago(@RequestBody Pago pago, @PathVariable Long id){
        if (!service.getById(id)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe el pago.");
        return ResponseEntity.status(HttpStatus.OK).body(service.update(pago, id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> realizarPago(@RequestBody Pago pago, @PathVariable Long id){
        if (!service.getById(id)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe el pago.");
        return ResponseEntity.status(HttpStatus.OK).body(service.pagar(pago, id));
    }
}
