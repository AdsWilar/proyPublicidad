package com.tallerdegrado1.publicidadserver.modelo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "negocio")
public class Negocio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 256)
    private String descripcion;
    @Column(name = "telefono", nullable = false)
    private Integer telefono;
    @Column(name = "ubicacion", nullable = false, length = 256)
    private String ubicacion;
    @Column(name = "foto", nullable = false, length = 256)
    private String foto;
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @PrePersist
    @PreUpdate
    private void interceptorInsertarActualizar() {
        nombre = nombre.toUpperCase();
    }
}
