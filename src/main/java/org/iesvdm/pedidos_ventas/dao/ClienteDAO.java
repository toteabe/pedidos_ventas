package org.iesvdm.pedidos_ventas.dao;

import org.iesvdm.pedidos_ventas.domain.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ClienteDAO<Cliente> extends RepositoryBase<Cliente>{
    public static org.iesvdm.pedidos_ventas.domain.Cliente newCliente(ResultSet rs) throws SQLException {
        return new org.iesvdm.pedidos_ventas.domain.Cliente(rs.getInt("id")
                , rs.getString("nombre")
                , rs.getString("apellido1")
                , rs.getString("apellido2")
                , rs.getString("ciudad")
                , rs.getInt("categoría")
        );
    }
}
