package med.voll.APIRest.paciente;

import med.voll.APIRest.direccion.DatosDireccion;

public record DatosRegistroPaciente(
        String nombre,
        String email,
        String telefono,
        String documentIdentidad,
        DatosDireccion direccion
) {
}
