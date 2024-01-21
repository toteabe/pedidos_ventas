package org.iesvdm.pedidos_ventas.domain;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comercial {

    @Min(value=0, message = "{msg.valid.min}")
    private int id;
    @NotNull(message = "{msg.valid.not.null}")
    @NotBlank(message = "{msg.valid.not.blank}")
    private String nombre;
    @NotNull(message = "{msg.valid.not.null}")
    @NotBlank(message = "{msg.valid.not.blank}")
    private String apellido1;
    private String apellido2;

    @DecimalMin(value = "0.3", message = "{msg.valid.min}")
    @DecimalMax(value="1.875", message = "{msg.valid.max}")
    private BigDecimal comisión;

}
