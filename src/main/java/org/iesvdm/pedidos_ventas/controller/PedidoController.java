package org.iesvdm.pedidos_ventas.controller;

import jakarta.validation.Valid;
import org.iesvdm.pedidos_ventas.domain.Comercial;
import org.iesvdm.pedidos_ventas.domain.Pedido;
import org.iesvdm.pedidos_ventas.domain.Cliente;
import org.iesvdm.pedidos_ventas.dto.PedidoFormDTO;
import org.iesvdm.pedidos_ventas.mapper.PedidoMapper;
import org.iesvdm.pedidos_ventas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoMapper pedidoMapper;

    @GetMapping("/pedidos")
    public String listar(Model model,
                         @RequestParam(required = false) Integer newPedidoID,
                         @RequestParam(required = false) Integer editPedidoID,
                         @RequestParam(required = false) Integer borradoPedidoID) {

        List<Pedido> listAllPed =  pedidoService.listAll();
        model.addAttribute("listaPedidos", listAllPed);

        if (newPedidoID != null) model.addAttribute("newPedidoID", newPedidoID);
        if (editPedidoID != null) model.addAttribute("editPedidoID", editPedidoID);
        if (borradoPedidoID != null) model.addAttribute("borradoPedidoID", borradoPedidoID);

        return "pedidos";

    }

    @GetMapping("/pedidos/{id}")
    public String detalle(Model model, @PathVariable Integer id ) {

        Pedido pedido = pedidoService.one(id);
        model.addAttribute("pedido", pedido);

        return "detalle-pedido";

    }

    @GetMapping("/pedidos/crear")
    public String crear(Model model) {

        PedidoFormDTO pedidoFormDTO = new PedidoFormDTO();
        model.addAttribute("pedidoFormDTO", pedidoFormDTO);

        List<Cliente> listaClientes = this.pedidoService.getAllClientes();
        model.addAttribute("listaClientes", listaClientes);

        List<Comercial> listaComerciales = this.pedidoService.getAllComercial();
        model.addAttribute("listaComerciales", listaComerciales);

        return "crear-pedido";

    }

    @PostMapping("/pedidos/crear")
    public String submitCrear(@Valid @ModelAttribute("pedidoFormDTO") PedidoFormDTO pedidoFormDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("pedidoFormDTO", pedidoFormDTO);

            List<Cliente> listaClientes = this.pedidoService.getAllClientes();
            model.addAttribute("listaClientes", listaClientes);

            List<Comercial> listaComerciales = this.pedidoService.getAllComercial();
            model.addAttribute("listaComerciales", listaComerciales);

            return "crear-pedido";
        }

        Pedido pedido = pedidoMapper.pedidoFormDTOAPedido(pedidoFormDTO);

        pedidoService.create(pedido);

        return "redirect:/pedidos?newPedidoID="+pedido.getId();

    }

    @GetMapping("/pedidos/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {

        Pedido pedido = pedidoService.one(id);
        PedidoFormDTO pedidoFormDTO = this.pedidoMapper.pedidoAPedidoFormDTO(pedido);
        model.addAttribute("pedidoFormDTO", pedidoFormDTO);

        List<Cliente> listaClientes = this.pedidoService.getAllClientes();
        model.addAttribute("listaClientes", listaClientes);

        List<Comercial> listaComerciales = this.pedidoService.getAllComercial();
        model.addAttribute("listaComerciales", listaComerciales);

        return "editar-pedido";

    }

    @PostMapping("/pedidos/editar/{id}")
    public String submitEditar(@Valid @ModelAttribute("pedidoFormDTO") PedidoFormDTO pedidoFormDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("pedidoFormDTO", pedidoFormDTO);

            List<Cliente> listaClientes = this.pedidoService.getAllClientes();
            model.addAttribute("listaClientes", listaClientes);

            List<Comercial> listaComerciales = this.pedidoService.getAllComercial();
            model.addAttribute("listaComerciales", listaComerciales);

            return "editar-pedido";
        }

        Pedido pedido = this.pedidoMapper.pedidoFormDTOAPedido(pedidoFormDTO);
        pedidoService.replace(pedido);

        return "redirect:/pedidos?editPedidoID="+pedido.getId();
    }

    @PostMapping("/pedidos/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable Integer id) {

        pedidoService.delete(id);

        return new RedirectView("/pedidos?borradoPedidoID="+id);
    }
}
