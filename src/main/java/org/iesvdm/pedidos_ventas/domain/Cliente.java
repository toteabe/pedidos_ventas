package org.iesvdm.pedidos_ventas.domain;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Min(value=0, message = "{msg.valid.min}")
    private int id;
    @NotNull(message = "{msg.valid.not.null}")
    @NotBlank(message = "{msg.valid.not.blank}")
    private String nombre;
    @NotNull(message = "{msg.valid.not.null}")
    @NotBlank(message = "{msg.valid.not.blank}")
    private String apellido1;
    private String apellido2;

    @NotNull(message = "{msg.valid.not.null}")
    @NotBlank(message = "{msg.valid.not.blank}")
    @Size( min=2, max= 50)
    private String ciudad;

    @Min(value=100, message = "{msg.valid.min}")
    @Max(value= 900, message = "{msg.valid.min}")
    //https://regex-generator.olafneumann.org/
    //categoria 000, 100, 200, ...900
    @Pattern(regexp = "\\d00", message = "{msg.valid.pattern.categoria}")
    private int categoria;

}
