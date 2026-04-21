package com.home.proyecto_ruta.controller;

import com.home.proyecto_ruta.entity.Dueno;
import com.home.proyecto_ruta.service.DuenoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/duenos")
public class DuenoController {

    DuenoService duenoService;

    public DuenoController(DuenoService duenoService) {
        this.duenoService = duenoService;
    }

    @PostMapping
    public ResponseEntity<Dueno> crearDueno(@Valid @RequestBody Dueno dueno){
        duenoService.guardar(dueno);
        return ResponseEntity.status(HttpStatus.CREATED).body(dueno);
    }
}
