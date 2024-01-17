package org.iesvdm.pedidos_ventas.dao;

import org.iesvdm.pedidos_ventas.domain.Cliente;
import org.iesvdm.pedidos_ventas.domain.Comercial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public interface PedidoDAO<Pedido> extends RepositoryBase<Pedido> {

    public Optional<Cliente> findClienteBy(int pedidoId);

    public Optional<Comercial> findComercialBy(int pedidoId);


}
