package org.iesvdm.pedidos_ventas.dao;

import org.iesvdm.pedidos_ventas.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteDAOImpl implements ClienteDAO<Cliente>{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Cliente cliente) {

    }

    @Override
    public List<Cliente> getAll() {

        return this.jdbcTemplate.query("""
                    select * from cliente
                """, (rs, rowNum) -> UtilDAO.newCliente(rs));

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
