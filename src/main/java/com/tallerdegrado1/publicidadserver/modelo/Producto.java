package com.tallerdegrado1.publicidadserver.modelo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 256)
    private String nombre;
    @Column(name = "id_categoria", nullable = false)
    private Integer idCategoria;

    @PrePersist
    @PreUpdate
    private void interceptorInsertarActualizar() {
        nombre = nombre.toUpperCase();
    }
}
