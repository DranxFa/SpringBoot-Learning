package com.home.proyecto_ruta.service;

import com.home.proyecto_ruta.entity.Dueno;
import com.home.proyecto_ruta.repository.DuenoRepository;
import org.springframework.stereotype.Service;

@Service
public class DuenoService {

    DuenoRepository duenoRepository;

    public DuenoService(DuenoRepository duenoRepository) {
        this.duenoRepository = duenoRepository;
    }

    public void guardar(Dueno dueno){
        duenoRepository.save(dueno);
    }

}
