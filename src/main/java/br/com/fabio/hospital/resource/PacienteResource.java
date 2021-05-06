 package br.com.fabio.hospital.resource;

import br.com.fabio.hospital.event.RecursoCriadoEvent;
import br.com.fabio.hospital.model.Paciente;
import br.com.fabio.hospital.repository.PacienteRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {
    private PacienteRepository pacienteRepository;
    private final ApplicationEventPublisher publisher;

    public PacienteResource(PacienteRepository pacienteRepository, ApplicationEventPublisher publisher) {
        this.pacienteRepository = pacienteRepository;
        this.publisher = publisher;
    }

    @PostMapping
    public ResponseEntity<Paciente> criar(@Valid @RequestBody Paciente paciente, HttpServletResponse response){
        Paciente pacienteSalva = pacienteRepository.save(paciente);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, pacienteSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalva);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPeloId(@PathVariable Long id) {
        return this.pacienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public  List<Paciente> listar(){
        return pacienteRepository.findAll();
    }

}
