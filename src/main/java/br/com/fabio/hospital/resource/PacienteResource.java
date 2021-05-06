 package br.com.fabio.hospital.resource;

import br.com.fabio.hospital.model.Paciente;
import br.com.fabio.hospital.repository.PacienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {
    private PacienteRepository pacienteRepository;

    public PacienteResource(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @PostMapping
    public ResponseEntity<Paciente> criar(@Valid @RequestBody Paciente paciente, HttpServletResponse response){
        Paciente pacienteSalva = pacienteRepository.save(paciente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(pacienteSalva.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(pacienteSalva);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPeloId(@PathVariable Long id) {
        return this.pacienteRepository.findById(id)
                .map(paciente -> ResponseEntity.ok(paciente))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public  List<Paciente> listar(){
        return pacienteRepository.findAll();
    }

}
