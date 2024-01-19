package org.iesvdm.pedidos_ventas.service;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.pedidos_ventas.dao.ClienteDAO;
import org.iesvdm.pedidos_ventas.dao.ComercialDAO;
import org.iesvdm.pedidos_ventas.dao.PedidoDAO;
import org.iesvdm.pedidos_ventas.domain.Cliente;
import org.iesvdm.pedidos_ventas.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PedidoService implements ServiceBase<Pedido> {

    @Autowired
    private PedidoDAO pedidoDAO;

    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private ComercialDAO comercialDAO;

    @Override
    public List<Pedido> listAll() {
        return this.pedidoDAO.getAll();
    }

    public List<Cliente> clientesByIdPedido(int id) {
        return this.pedidoDAO.getAllClientesByIdPedido(id);
    }

    public List<Cliente> getAllClientes() {
        return this.clienteDAO.getAll();
    }

    public List<Comercial> getAllComercial() {return this;}

    @Override
    public Pedido one(int id) {
        Optional<Pedido> pedidoOptional =this.pedidoDAO.find(id);
        if (pedidoOptional.isPresent()) return pedidoOptional.get();
        return null;
    }

    @Override
    public void create(Pedido pedido) {

        this.pedidoDAO.create(pedido);
        log.info("Creado pedido con id {}", pedido.getId());

    }

    @Override
    public void replace(Pedido pedido) {

        this.pedidoDAO.update(pedido);
        log.info("Actualizado pedido con id {}", pedido.getId());
        log.debug("Pedido Actualizaro:\n{}", pedido.toString());
    }

    @Override
    public void delete(int id) {

        this.pedidoDAO.delete(id);
        log.info("Borrado pedido con id {}", id);

    }
}
