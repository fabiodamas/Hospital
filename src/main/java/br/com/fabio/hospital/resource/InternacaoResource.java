 package br.com.fabio.hospital.resource;

import br.com.fabio.hospital.event.RecursoCriadoEvent;
import br.com.fabio.hospital.exception.PacienteInexistenteOuInativaException;
import br.com.fabio.hospital.exceptionhandler.HospitalExceptionHandler;
import br.com.fabio.hospital.model.Internacao;
import br.com.fabio.hospital.repository.InternacaoRepository;
import br.com.fabio.hospital.service.InternacaoService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

 @RestController
 @RequestMapping("/internacoes")
 public class InternacaoResource {
     private InternacaoRepository internacaoRepository;
     private final ApplicationEventPublisher publisher;
     private final InternacaoService internacaoService;
     private final MessageSource messageSource;
 
     public InternacaoResource(InternacaoRepository internacaoRepository, ApplicationEventPublisher publisher, InternacaoService internacaoService, MessageSource messageSource) {
         this.internacaoRepository = internacaoRepository;
         this.publisher = publisher;
         this.internacaoService = internacaoService;
         this.messageSource = messageSource;
     }
 

 
 
     @GetMapping("/{id}")
     public ResponseEntity<Internacao> buscarPeloId(@PathVariable Long id) {
         return this.internacaoRepository.findById(id)
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
     }
 
     @GetMapping
     public  List<Internacao> listar(){
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

     @PostMapping
     public ResponseEntity<Internacao> criar(@Valid @RequestBody Internacao internacao, HttpServletResponse response)  {
         Internacao internacaoSalvo = internacaoService.salvar(internacao);
         publisher.publishEvent(new RecursoCriadoEvent(this, response, internacaoSalvo.getId()));
         return ResponseEntity.status(HttpStatus.CREATED).body(internacaoSalvo);
     }

     @ExceptionHandler({ PacienteInexistenteOuInativaException.class })
     public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PacienteInexistenteOuInativaException ex) {
         String mensagemUsuario = messageSource.getMessage("paciente.inexistente-ou-inativa", null, LocaleContextHolder.getLocale());
         String mensagemDesenvolvedor = ex.toString();
         List<HospitalExceptionHandler.Erro> erros = Collections.singletonList(new HospitalExceptionHandler.Erro(mensagemUsuario, mensagemDesenvolvedor));
         return ResponseEntity.badRequest().body(erros);
     }

 }
