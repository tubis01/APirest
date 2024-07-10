package med.voll.APIRest.medico;

public record DatosListadoMedico(
        Long id,
        String nombre,
        String especialidad,
        String documento,
        String email
) {

    public DatosListadoMedico(Medico medico){
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getEspecialidad().name(),
                medico.getDocumento(),
                medico.getEmail()
                );
    }
}
