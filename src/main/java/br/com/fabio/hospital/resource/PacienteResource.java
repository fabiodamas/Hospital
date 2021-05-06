 package br.com.fabio.hospital.resource;

import br.com.fabio.hospital.event.RecursoCriadoEvent;
import br.com.fabio.hospital.model.Paciente;
import br.com.fabio.hospital.repository.PacienteRepository;
import br.com.fabio.hospital.service.PacienteService;
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
    private final PacienteService pacienteService;

    public PacienteResource(PacienteRepository pacienteRepository, ApplicationEventPublisher publisher, PacienteService pessoaService) {
        this.pacienteRepository = pacienteRepository;
        this.publisher = publisher;
        this.pacienteService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Paciente> criar(@Valid @RequestBody Paciente paciente, HttpServletResponse response){
        Paciente pacienteSalvo = pacienteRepository.save(paciente);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, pacienteSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        pacienteRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizar(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
        Paciente pessoaSalva = pacienteService.atualizar(id, paciente);
        return ResponseEntity.ok(pessoaSalva);
    }

    @PutMapping("/{id}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean ativo) {
        pacienteService.atualizarPropriedadeAtivo(id, ativo);
    }


}
