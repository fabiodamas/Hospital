 package br.com.fabio.hospital.resource;

import br.com.fabio.hospital.model.Especialidade;
import br.com.fabio.hospital.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeResource {
    private EspecialidadeRepository especialidadeRepository;

    public EspecialidadeResource(EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    @PostMapping
    public ResponseEntity<Especialidade> criar(@RequestBody Especialidade especialidade,  HttpServletResponse response){
        Especialidade especialidadeSalva = especialidadeRepository.save(especialidade);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(especialidadeSalva.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(especialidadeSalva);
    }

    @GetMapping
    public  List<Especialidade> listar(){
        return especialidadeRepository.findAll();
    }
}
