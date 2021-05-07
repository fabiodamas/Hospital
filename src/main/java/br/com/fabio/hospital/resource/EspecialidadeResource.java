 package br.com.fabio.hospital.resource;

import br.com.fabio.hospital.event.RecursoCriadoEvent;
import br.com.fabio.hospital.model.Especialidade;
import br.com.fabio.hospital.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

 @RestController
@RequestMapping("/api/especialidades")
public class EspecialidadeResource {
    private EspecialidadeRepository especialidadeRepository;
    private final ApplicationEventPublisher publisher;

    public EspecialidadeResource(EspecialidadeRepository especialidadeRepository, ApplicationEventPublisher publisher) {
        this.especialidadeRepository = especialidadeRepository;
        this.publisher = publisher;
    }

    @PostMapping
    public ResponseEntity<Especialidade> criar(@Valid @RequestBody Especialidade especialidade, HttpServletResponse response){
        Especialidade especialidadeSalva = especialidadeRepository.save(especialidade);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, especialidadeSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadeSalva);
    }

     @GetMapping("/{id}")
     public ResponseEntity<Especialidade> buscarPeloCodigo(@PathVariable Long id) {
         return this.especialidadeRepository.findById(id)
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
     }

    @GetMapping
    public  Iterable<Especialidade> listar(){
        return especialidadeRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        especialidadeRepository.deleteById(id);
    }

}
