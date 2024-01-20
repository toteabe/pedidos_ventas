package org.iesvdm.pedidos_ventas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String ciudad;
    private int categoria;



}
