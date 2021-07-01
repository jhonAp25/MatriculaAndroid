package com.matricula.api.service;

import com.matricula.api.model.Pago;
import com.matricula.api.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class PagoService {

    @Autowired
    private PagoRepository repository;

    public List<Pago> getAll(){
        return repository.findAll();
    }

    public Boolean getById(Long id){
        return repository.existsById(id);
    }

    public String create(Pago pago){
        repository.save(pago);
        return "Pago Creado.";
    }

    public String update(Pago pago, Long id){
        Pago pagoUpd = repository.getById(id);

        pagoUpd.setFechaPago(pago.getFechaPago());
        pagoUpd.setDescripcion(pago.getDescripcion());
        pagoUpd.setEstado(pago.getEstado());
        pagoUpd.setMensualidad(pago.getMensualidad());
        pagoUpd.setAlumno(pago.getAlumno());

        repository.save(pagoUpd);
        return "Pago Actualizado.";
    }



    public String pagar(Pago pago, Long id){
        LocalDate date = LocalDate.now();
        Pago pagar = repository.getById(id);

        pagar.setDescripcion(pago.getDescripcion());
        pagar.setFechaPago(date);
        pagar.setEstado(true);
        repository.save(pagar);
        return "Pago Realizado del mes de "+pagar.getMensualidad().getMes();
    }
    public List<Pago> listadoDni(String dni){
        return repository.findAllByAlumno_Dni(dni);
    }

}
