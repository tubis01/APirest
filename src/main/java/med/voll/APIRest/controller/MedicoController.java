package med.voll.APIRest.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.APIRest.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico registroMedico){
        medicoRepository.save( new Medico(registroMedico));
    }

    @GetMapping
    public Page<DatosListadoMedico> listarMedicos(@PageableDefault(sort = "documento") Pageable paginacion){
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico){
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico( @PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
    }
//    }    public void eliminarMedico( @PathVariable Long id){
//        Medico medico = medicoRepository.getReferenceById(id);
//        medicoRepository.delete(medico);
//    }

}
