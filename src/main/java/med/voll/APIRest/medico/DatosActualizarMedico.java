package med.voll.APIRest.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.APIRest.direccion.DatosDireccion;

public record DatosActualizarMedico(
        @NotNull
        Long id,
        String nombre,
        String documento,
        DatosDireccion direccion
) {
}
