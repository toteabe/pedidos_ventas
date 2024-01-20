package org.iesvdm.pedidos_ventas.dao;

import org.iesvdm.pedidos_ventas.domain.Comercial;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ComercialDAOImpl implements ComercialDAO<Comercial>{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Comercial comcercial) {

    }

    @Override
    public List<Comercial> getAll() {
        return this.jdbcTemplate.query("""
                select * from comercial
                """, (rs, rowNum) -> UtilDAO.newComercial(rs));
    }

    @Override
    public Optional<Comercial> find(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Comercial comcercial) {

    }

    @Override
    public void delete(long id) {

    }
}
