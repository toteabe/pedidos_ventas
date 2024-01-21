package org.iesvdm.pedidos_ventas.mapper;

import org.iesvdm.pedidos_ventas.domain.Pedido;
import org.iesvdm.pedidos_ventas.dto.PedidoFormDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(source = "pedido.cliente.id", target = "idCliente")
    @Mapping(source = "pedido.comercial.id", target = "idComercial")
    public PedidoFormDTO pedidoAPedidoFormDTO(Pedido pedido);

    @Mapping(source = "idCliente", target = "cliente.id")
    @Mapping(source = "idComercial", target = "comercial.id")
    public Pedido pedidoFormDTOAPedido(PedidoFormDTO pedidoFormDTO);

}
