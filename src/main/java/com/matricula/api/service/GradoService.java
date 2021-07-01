package com.matricula.api.service;

import com.matricula.api.model.Grado;
import com.matricula.api.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GradoService {

    @Autowired
    private GradoRepository repository;

    public List<Grado> getAll(){
        return repository.findAll();
    }

    public Boolean getById(Long id){
        return repository.existsById(id);
    }

    public String create(Grado grado){
        repository.save(grado);
        return "Grado \""+grado.getDescripcion()+"\" creado.";
    }

    public String update(Grado grado, Long id){
        Grado gradoUpdt = repository.getById(id);
        gradoUpdt.setDescripcion(grado.getDescripcion());

        repository.save(gradoUpdt);
        return "Grado \""+grado.getDescripcion()+"\" actualizado.";
    }
}
