package br.com.fabio.hospital;

/* 
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import io.github.fabiodamas.hospitalar.model.repository.UsuarioRepository;
@Component
public class CargaInicial implements ApplicationRunner  {
	// @Autowired
	// private UsuarioRepository usuarioRepository;
	// private GroupRepository repository;
	public CargaInicial(UsuarioRepository usuarioRepository) {
	// public CargaInicial(GroupRepository repository) {
		// this.usuarioRepository = usuarioRepository;
		// this.repository = repository;
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario fabio = Usuario.builder().id(1).nome("fabio damas").email("fabio.damas@gmail.com").senha("123").build();
		Usuario ludmila = Usuario.builder().id(2).nome("ludmila garcia").email("lulu@gmail.com").senha("123").build();
		
		
		usuarioRepository.saveAndFlush(fabio);
		usuarioRepository.saveAndFlush(ludmila);
		Stream.of("Denver JUG", "Utah JUG", "Seattle JUG",
				"Richmond JUG").forEach(name ->	repository.save(new Group(name))
		);
		Group djug = repository.findByName("Denver JUG");
		Event e = Event.builder().title("Full Stack Reactive")
				.description("Reactive with Spring Boot + React")
				.date(Instant.parse("2018-12-12T18:00:00.000Z"))
				.build();
		djug.setEvents(Collections.singleton(e));
		repository.save(djug);
		repository.findAll().forEach(System.out::println);
	}
	
	
}
*/