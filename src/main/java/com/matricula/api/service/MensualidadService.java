package com.matricula.api.service;

import com.matricula.api.model.Mensualidad;
import com.matricula.api.repository.MensualidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class MensualidadService {

    @Autowired
    private MensualidadRepository repository;

    public List<Mensualidad> getAll(){
        return repository.findAll();
    }

    public Boolean getById(Long id){
        return repository.existsById(id);
    }

    public String create(Mensualidad mensualidad){
        repository.save(mensualidad);
        return "Mensualidad Creada.";
    }

    public String update(Mensualidad mensualidad, Long id){
        Mensualidad mensualidadUpd = repository.getById(id);

        mensualidadUpd.setFechaInicio(mensualidad.getFechaInicio());
        mensualidadUpd.setFechaFinal(mensualidad.getFechaFinal());
        mensualidadUpd.setMes(mensualidad.getMes());
        mensualidadUpd.setMonto(mensualidad.getMonto());

        repository.save(mensualidadUpd);
        return "Mensualidad Actualizada.";
    }
}
