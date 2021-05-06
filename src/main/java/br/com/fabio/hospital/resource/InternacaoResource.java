 package br.com.fabio.hospital.resource;

import br.com.fabio.hospital.event.RecursoCriadoEvent;
import br.com.fabio.hospital.model.Internacao;
import br.com.fabio.hospital.repository.InternacaoRepository;
import br.com.fabio.hospital.service.InternacaoService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

 @RestController
 @RequestMapping("/internacoes")
 public class InternacaoResource {
     private InternacaoRepository internacaoRepository;
     private final ApplicationEventPublisher publisher;
     private final InternacaoService internacaoService;
 
     public InternacaoResource(InternacaoRepository internacaoRepository, ApplicationEventPublisher publisher, InternacaoService pessoaService) {
         this.internacaoRepository = internacaoRepository;
         this.publisher = publisher;
         this.internacaoService = pessoaService;
     }
 
     @PostMapping
     public ResponseEntity<Internacao> criar(@Valid @RequestBody Internacao internacao, HttpServletResponse response)  {
         Internacao internacaoSalvo = internacaoRepository.save(internacao);
         publisher.publishEvent(new RecursoCriadoEvent(this, response, internacaoSalvo.getId()));
         return ResponseEntity.status(HttpStatus.CREATED).body(internacaoSalvo);
     }
 
 
     @GetMapping("/{id}")
     public ResponseEntity<Internacao> buscarPeloId(@PathVariable Long id) {
         return this.internacaoRepository.findById(id)
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
     }
 
     @GetMapping
     public  List<Internacao> listar(){
         int a=1;
         a=a+2;
         return internacaoRepository.findAll();
     }
 
     @DeleteMapping("/{id}")
     @ResponseStatus(HttpStatus.NO_CONTENT)
     public void remover(@PathVariable Long id) {
         internacaoRepository.deleteById(id);
     }
 
     @PutMapping("/{id}")
     public ResponseEntity<Internacao> atualizar(@PathVariable Long id, @Valid @RequestBody Internacao internacao) {
         Internacao pessoaSalva = internacaoService.atualizar(id, internacao);
         return ResponseEntity.ok(pessoaSalva);
     }

 }
