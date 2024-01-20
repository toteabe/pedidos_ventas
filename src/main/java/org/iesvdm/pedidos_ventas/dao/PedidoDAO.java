package org.iesvdm.pedidos_ventas.dao;

import org.iesvdm.pedidos_ventas.domain.Cliente;
import org.iesvdm.pedidos_ventas.domain.Comercial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PedidoDAO<T> extends RepositoryBase<T> {

    public Optional<Cliente> findClienteBy(int pedidoId);

    public Optional<Comercial> findComercialBy(int pedidoId);


    public List<Cliente> getAllClientesByIdPedido(int pedidoId);

}
