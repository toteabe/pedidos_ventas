package org.iesvdm.pedidos_ventas.service;

import org.iesvdm.pedidos_ventas.dao.PedidoDAO;
import org.iesvdm.pedidos_ventas.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements ServiceBase<Pedido> {

    @Autowired
    private PedidoDAO pedidoDAO;

    @Override
    public List<Pedido> listAll() {
        return null;
    }

    @Override
    public Pedido one(int id) {
        return null;
    }

    @Override
    public void create(Pedido pedido) {

    }

    @Override
    public void replace(Pedido pedido) {

    }

    @Override
    public void delete(int id) {

    }
}
