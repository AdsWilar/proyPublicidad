package com.tallerdegrado1.publicidadserver.modelo;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "detalle_producto_negocio")
@Data
public class DetalleProducoNegocio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descripcion", nullable = false, length = 256)
    private String descripcion;
    @Column(name = "foto", nullable = false, length = 256)
    private String foto;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;
    @Column(name = "id_negocio", nullable = false)
    private Integer idNegocio;
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

}
