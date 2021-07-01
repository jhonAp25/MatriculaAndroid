package com.matricula.api.service;

import com.matricula.api.model.Alumno;
import com.matricula.api.model.Mensualidad;
import com.matricula.api.model.Pago;
import com.matricula.api.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    @Autowired
    private MensualidadService serviceMensualidad;

    @Autowired
    private PagoService servicePago;

    public List<Alumno> getAll(){
        return repository.findAll();
    }

    public Boolean getById(Long id){
        return repository.existsById(id);
    }

    public List<Alumno> findByNombreOrApellido(String n, String a){
        return repository.findByNombreContainsOrApellidoContains(n, a);
    }

    public String create(Alumno alumno){
        repository.save(alumno);

        List<Mensualidad> mensualidades = serviceMensualidad.getAll();
        Alumno alumnoPago = repository.findByNombre(alumno.getNombre());

        for (Mensualidad mensualidad : mensualidades){
            Pago mensualidadPago = new Pago();
            mensualidadPago.setMensualidad(mensualidad);
            mensualidadPago.setAlumno(alumnoPago);
            servicePago.create(mensualidadPago);
        }
        return "Alumno \""+alumno.getNombre()+"\" creado.";
    }

    public String update(Alumno alumno, Long id){
        Alumno alumnoUpdt = repository.getById(id);

        alumnoUpdt.setNombre(alumno.getNombre());
        alumnoUpdt.setApellido(alumno.getApellido());
        alumnoUpdt.setTelefono(alumno.getTelefono());
        alumnoUpdt.setDni(alumno.getDni());
        alumnoUpdt.setCorreo(alumno.getCorreo());
        alumnoUpdt.setEstado(alumno.getEstado());
        alumnoUpdt.setGrado(alumnoUpdt.getGrado());

        repository.save(alumnoUpdt);
        return "Alumno \""+alumno.getNombre()+"\" actualizado.";
    }

    public String changeStatus(Long id){
        Alumno alumno = repository.getById(id);
        alumno.setEstado(!alumno.getEstado());
        repository.save(alumno);

        return "Se actualizó el estado del alumno "+alumno.getNombre();
    }
}
