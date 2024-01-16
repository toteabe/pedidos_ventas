package org.iesvdm.pedidos_ventas.dao;

import java.util.List;
import java.util.Optional;

public interface RepositoryBase<T> {
    public void create(T t);

    public List<T> getAll();
    public Optional<T> find(int id);

    public void update(T t);

    public void delete(long id);
}
