 package br.com.fabio.hospital.resource;

import br.com.fabio.hospital.model.Especialidade;
import br.com.fabio.hospital.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeResource {
    @Autowired
     private EspecialidadeRepository especialidadeRepository;

    @GetMapping
    public List<Especialidade> listar(){
        return especialidadeRepository.findAll();
    }
}
