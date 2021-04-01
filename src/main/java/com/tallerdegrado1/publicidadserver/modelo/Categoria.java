package com.tallerdegrado1.publicidadserver.modelo;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 256)
    private String descripcion;
    @Column(name = "foto", nullable = false, length = 256)
    private String foto;
    @PrePersist
    @PreUpdate
    private void interceptorInsertarActualizar() {
        nombre = nombre.toUpperCase();
    }
}
