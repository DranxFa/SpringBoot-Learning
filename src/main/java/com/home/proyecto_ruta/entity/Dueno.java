package com.home.proyecto_ruta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
public class Dueno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombre;

    @NotBlank(message = "El telefono no puede estar vacío.")
    @Pattern(regexp = "^\\d{9}$", message = "El numero debe tener nueve digitos.")
    private String telefono;

    @NotBlank(message = "El correo no puede estar vacio.")
    @Email(message = "El formato del correo no es valido.")
    private String correo;

    @OneToMany(mappedBy = "dueno", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Mascota> mascota;

    public Dueno() {
    }

    public Dueno(Long id, String nombre, String telefono, List<Mascota> mascota, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mascota = mascota;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Mascota> getMascota() {
        return mascota;
    }

    public void setMascota(List<Mascota> mascota) {
        this.mascota = mascota;
    }
}
