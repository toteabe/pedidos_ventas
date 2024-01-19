package org.iesvdm.pedidos_ventas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private int id;
    private double total;
    private Date fecha;
    private int idCliente;
    private Cliente cliente;
    private int idComercial;
    private Comercial comercial;

}
