package org.iesvdm.pedidos_ventas.controller;

import org.iesvdm.pedidos_ventas.domain.Pedido;
import org.iesvdm.pedidos_ventas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedidos")
    public String listar(Model model) {

        List<Pedido> listAllPed =  pedidoService.listAll();
        model.addAttribute("listaPedidos", listAllPed);

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

        Pedido pedido = new Pedido();
        model.addAttribute("pedido", pedido);

        return "crear-pedido";

    }

    @PostMapping("/pedidos/crear")
    public RedirectView submitCrear(@ModelAttribute("pedido") Pedido pedido) {

        pedidoService.create(pedido);

        return new RedirectView("/pedidos") ;

    }

    @GetMapping("/pedidos/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {

        Pedido pedido = pedidoService.one(id);
        model.addAttribute("pedido", pedido);

        return "editar-pedido";

    }


    @PostMapping("/pedidos/editar/{id}")
    public RedirectView submitEditar(@ModelAttribute("pedido") Pedido pedido) {

        pedidoService.replace(pedido);

        return new RedirectView("/pedidos");
    }

    @PostMapping("/pedidos/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable Integer id) {

        pedidoService.delete(id);

        return new RedirectView("/pedidos");
    }
}
