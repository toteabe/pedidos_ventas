package org.iesvdm.pedidos_ventas.dao;

import org.iesvdm.pedidos_ventas.domain.Cliente;
import org.iesvdm.pedidos_ventas.domain.Comercial;
import org.iesvdm.pedidos_ventas.domain.Pedido;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilDAO {

    public static Pedido newPedido(ResultSet rs) throws SQLException {
        return new org.iesvdm.pedidos_ventas.domain.Pedido(rs.getInt("id"),
                rs.getDouble("total"),
                rs.getDate("fecha"),
                new Cliente(rs.getInt("C.id"),
                        rs.getString("C.nombre"),
                        rs.getString("C.apellido1"),
                        rs.getString("C.apellido2"),
                        rs.getString("C.ciudad"),
                        rs.getInt("C.categoría")
                ),
                new Comercial(rs.getInt("CO.id"),
                        rs.getString("CO.nombre"),
                        rs.getString("CO.apellido1"),
                        rs.getString("CO.apellido2"),
                        rs.getDouble("CO.comisión")
                )
        );
    }
}
