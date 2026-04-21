package com.home.proyecto_ruta.controller;

import com.home.proyecto_ruta.dto.MascotaDTO;
import com.home.proyecto_ruta.entity.Mascota;
import com.home.proyecto_ruta.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public ResponseEntity<List<Mascota>> obtenerMascotas(){
        return ResponseEntity.ok(mascotaService.listarTodas());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Mascota>> obtenerEspecies(@RequestParam String especie){
        return ResponseEntity.ok(mascotaService.listarEspecies(especie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> obtenerMascota(@PathVariable Long id){
        return ResponseEntity.ok(mascotaService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Mascota> crearMascota(@Valid @RequestBody MascotaDTO mascotaDto){
        Mascota mascotaNueva = mascotaService.guardar(mascotaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarMascota(@PathVariable Long id, @Valid @RequestBody MascotaDTO mascotaDto){
        mascotaService.actualizar(id, mascotaDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id){
        mascotaService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
