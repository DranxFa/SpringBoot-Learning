package com.home.proyecto_ruta.service;

import com.home.proyecto_ruta.dto.MascotaDTO;
import com.home.proyecto_ruta.entity.Dueno;
import com.home.proyecto_ruta.entity.Mascota;
import com.home.proyecto_ruta.repository.DuenoRepository;
import com.home.proyecto_ruta.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    MascotaRepository mascotaRepository;
    DuenoRepository duenoRepository;

    public MascotaService(MascotaRepository mascotaRepository, DuenoRepository duenoRepository) {
        this.mascotaRepository = mascotaRepository;
        this.duenoRepository = duenoRepository;
    }

    public List<Mascota> listarTodas(){
        return mascotaRepository.findAll();
    }

    public Mascota buscar(Long id){
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
    }

    public Mascota guardar(MascotaDTO mascotaDto){
        Dueno dueno = duenoRepository.findById(mascotaDto.duenoId())
                .orElseThrow(() -> new RuntimeException("Dueño no encontrado con id: " + mascotaDto.duenoId()));

        Mascota mascota = new Mascota();
        mascota.setNombre(mascotaDto.nombre());
        mascota.setEdad(mascotaDto.edad());
        mascota.setEspecie(mascotaDto.especie());
        mascota.setDueno(dueno);
        return mascotaRepository.save(mascota);
    }

    public void actualizar(Long id, MascotaDTO mascotaDto) {
        Mascota mascotaAProcesar = mascotaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Mascota no encontrada con id: " + id));

        mascotaAProcesar.setNombre(mascotaDto.nombre());
        mascotaAProcesar.setEspecie(mascotaDto.especie());
        mascotaAProcesar.setEdad(mascotaDto.edad());
        mascotaRepository.save(mascotaAProcesar);
    }

    public void eliminar(Long id) {
        mascotaRepository.deleteById(id);
    }

    public List<Mascota> listarEspecies(String especie){
        return mascotaRepository.findByEspecie(especie);
    }
}

