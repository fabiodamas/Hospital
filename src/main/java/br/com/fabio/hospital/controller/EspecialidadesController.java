 package br.com.fabio.hospital.controller;

import br.com.fabio.hospital.model.Especialidade;
import br.com.fabio.hospital.repository.EspecialidadeRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
@RequestMapping("/especialidades")
public class EspecialidadesController {
    private EspecialidadeRepository especialidadeRepository;
    private final String ESPECIALIDADE_URI = "especialidades/";

    public EspecialidadesController(EspecialidadeRepository especialidadeRepository, ApplicationEventPublisher publisher) {
        this.especialidadeRepository = especialidadeRepository;
    }

    @GetMapping
    public ModelAndView listar(){
		Iterable<Especialidade> especialidades = especialidadeRepository.findAll();
        return new ModelAndView(ESPECIALIDADE_URI + "list","especialidades",especialidades);
    }       
    
    @GetMapping("/{id}")
	public ModelAndView view(@PathVariable("id") Especialidade especialidade) {
		return new ModelAndView(ESPECIALIDADE_URI + "view","especialidade",especialidade);
	} 
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Especialidade especialidade) {
        return new ModelAndView(ESPECIALIDADE_URI + "form");
	}

	@PostMapping("/form")
	public ModelAndView create(@Valid Especialidade especialidade,BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) { return new ModelAndView(ESPECIALIDADE_URI + "form","formErrors",result.getAllErrors()); }
		especialidade = this.especialidadeRepository.save(especialidade);
		redirect.addFlashAttribute("globalMessage","Especialidade gravado com sucesso");
		return new ModelAndView("redirect:/" + ESPECIALIDADE_URI + "{especialidade.id}","especialidade.id",especialidade.getId());
	}

	@GetMapping(value = "remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id,RedirectAttributes redirect) {
		this.especialidadeRepository.deleteById(id);
		Iterable<Especialidade> especialidades = this.especialidadeRepository.findAll();
		
		ModelAndView mv = new ModelAndView(ESPECIALIDADE_URI + "list","especialidades",especialidades);
		mv.addObject("globalMessage","Especialidade removido com sucesso");
	
		return mv;
	}

	@GetMapping(value = "alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Especialidade especialidade) {
		return new ModelAndView(ESPECIALIDADE_URI + "form","especialidade",especialidade);
	}

}
