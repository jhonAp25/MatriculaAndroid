package com.matricula.api.config;

import com.matricula.api.model.Mensualidad;
import com.matricula.api.service.MensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

@Component
public class Data {

    @Autowired
    private MensualidadService service;

    @PostConstruct
    public void init(){
        LocalDate date = LocalDate.now();
        int year = date.getYear();

        Mensualidad mensualidad1 = new Mensualidad();
        mensualidad1.setFechaInicio(LocalDate.of(year, Month.MARCH, 01));
        mensualidad1.setFechaFinal(mensualidad1.getFechaInicio().with(TemporalAdjusters.lastDayOfMonth()));
        mensualidad1.setMes("Marzo");
        mensualidad1.setMonto("250");
        service.create(mensualidad1);

        Mensualidad mensualidad2 = new Mensualidad();
        mensualidad2.setFechaInicio(LocalDate.of(year, Month.APRIL, 01));
        mensualidad2.setFechaFinal(mensualidad2.getFechaInicio().with(TemporalAdjusters.lastDayOfMonth()));
        mensualidad2.setMes("Abril");
        mensualidad2.setMonto("250");
        service.create(mensualidad2);

        Mensualidad mensualidad3 = new Mensualidad();
        mensualidad3.setFechaInicio(LocalDate.of(year, Month.MAY, 01));
        mensualidad3.setFechaFinal(mensualidad3.getFechaInicio().with(TemporalAdjusters.lastDayOfMonth()));
        mensualidad3.setMes("Mayo");
        mensualidad3.setMonto("250");
        service.create(mensualidad3);

        Mensualidad mensualidad4 = new Mensualidad();
        mensualidad4.setFechaInicio(LocalDate.of(year, Month.JUNE, 01));
        mensualidad4.setFechaFinal(mensualidad4.getFechaInicio().with(TemporalAdjusters.lastDayOfMonth()));
        mensualidad4.setMes("Junio");
        mensualidad4.setMonto("250");
        service.create(mensualidad4);

        Mensualidad mensualidad5 = new Mensualidad();
        mensualidad5.setFechaInicio(LocalDate.of(year, Month.JULY, 01));
        mensualidad5.setFechaFinal(mensualidad5.getFechaInicio().with(TemporalAdjusters.lastDayOfMonth()));
        mensualidad5.setMes("Julio");
        mensualidad5.setMonto("250");
        service.create(mensualidad5);

        Mensualidad mensualidad6 = new Mensualidad();
        mensualidad6.setFechaInicio(LocalDate.of(year, Month.AUGUST, 01));
        mensualidad6.setFechaFinal(mensualidad6.getFechaInicio().with(TemporalAdjusters.lastDayOfMonth()));
        mensualidad6.setMes("Agosto");
        mensualidad6.setMonto("250");
        service.create(mensualidad6);

        Mensualidad mensualidad7 = new Mensualidad();
        mensualidad7.setFechaInicio(LocalDate.of(year, Month.SEPTEMBER, 01));
        mensualidad7.setFechaFinal(mensualidad7.getFechaInicio().with(TemporalAdjusters.lastDayOfMonth()));
        mensualidad7.setMes("Setiembre");
        mensualidad7.setMonto("250");
        service.create(mensualidad7);

        Mensualidad mensualidad8 = new Mensualidad();
        mensualidad8.setFechaInicio(LocalDate.of(year, Month.OCTOBER, 01));
        mensualidad8.setFechaFinal(mensualidad8.getFechaInicio().with(TemporalAdjusters.lastDayOfMonth()));
        mensualidad8.setMes("Octubre");
        mensualidad8.setMonto("250");
        service.create(mensualidad8);

        Mensualidad mensualidad9 = new Mensualidad();
        mensualidad9.setFechaInicio(LocalDate.of(year, Month.NOVEMBER, 01));
        mensualidad9.setFechaFinal(mensualidad9.getFechaInicio().with(TemporalAdjusters.lastDayOfMonth()));
        mensualidad9.setMes("Noviembre");
        mensualidad9.setMonto("250");
        service.create(mensualidad9);

        Mensualidad mensualidad10 = new Mensualidad();
        mensualidad10.setFechaInicio(LocalDate.of(year, Month.DECEMBER, 01));
        mensualidad10.setFechaFinal(mensualidad10.getFechaInicio().with(TemporalAdjusters.lastDayOfMonth()));
        mensualidad10.setMes("Diciembre");
        mensualidad10.setMonto("250");
        service.create(mensualidad10);
    }

}
