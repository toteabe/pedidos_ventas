package org.iesvdm.pedidos_ventas.dao;

import org.iesvdm.pedidos_ventas.domain.Cliente;

import java.util.List;
import java.util.Optional;

public class ClienteDAOImpl implements ClienteDAO<Cliente>{
    @Override
    public void create(Cliente cliente) {

    }

    @Override
    public List<Cliente> getAll() {
        return null;
    }

    @Override
    public Optional<Cliente> find(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(long id) {

    }
}
