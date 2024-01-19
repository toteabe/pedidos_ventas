package org.iesvdm.pedidos_ventas.dao;

import java.util.List;
import java.util.Optional;
import org.iesvdm.pedidos_ventas.domain.Comercial;

public class ComercialDAOImpl<Comercial> implements ComercialDAO<Comercial>{
    @Override
    public void create(Comercial comcercial) {

    }

    @Override
    public List<Comercial> getAll() {
        return null;
    }

    @Override
    public Optional<Comercial> find(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Comcercial comcercial) {

    }

    @Override
    public void delete(long id) {

    }
}
