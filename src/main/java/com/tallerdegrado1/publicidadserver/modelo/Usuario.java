package com.tallerdegrado1.publicidadserver.modelo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 256)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 256)
    private String apellido;
    @Column(name = "telefono", nullable = false)
    private Integer telefono;
    @Column(name = "correo", nullable = false, length = 256)
    private String correo;
    @Column(name = "foto", nullable = false, length = 256)
    private String foto;
    @Column(name = "usu", nullable = false, length = 50)
    private String usu;
    @Column(name = "pass", nullable = false, length = 256)
    private String pass;

}
