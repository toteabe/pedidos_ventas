package org.iesvdm.pedidos_ventas.service;

import java.util.List;

public interface ServiceBase<T> {

    public List<T> listAll();
    public T one(int id);
    public void create(T t);
    public void replace(T t);
    public void delete(int id);
}
