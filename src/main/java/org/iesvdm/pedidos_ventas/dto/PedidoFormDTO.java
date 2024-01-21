package org.iesvdm.pedidos_ventas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesvdm.pedidos_ventas.domain.Cliente;
import org.iesvdm.pedidos_ventas.domain.Comercial;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoFormDTO {
    @Min(value=0, message = "{msg.valid.min}")
    private int id;

    @NotNull(message = "{msg.valid.not.null}")
    @DecimalMin(value="0.0", message = "{msg.valid.min}")
    @DecimalMax(value="100.0", message = "{msg.valid.max}")
    private Double total;

    @NotNull(message = "{msg.valid.not.null}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    @Min(value=1, message = "{msg.valid.min}")
    private int idCliente;
    @Min(value=1, message = "{msg.valid.min}")
    private int idComercial;
}
