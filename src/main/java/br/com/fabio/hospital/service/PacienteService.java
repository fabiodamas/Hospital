package br.com.fabio.hospital.service;

import br.com.fabio.hospital.model.Paciente;
import br.com.fabio.hospital.repository.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente atualizar(Long id, Paciente paciente) {
        Paciente pacienteSalvo = pacienteRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        BeanUtils.copyProperties(paciente, pacienteSalvo, "id");
        return pacienteRepository.save(pacienteSalvo);
    }

    public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
        Paciente pacienteSalvo = buscarPessoaPeloCodigo(id);
        pacienteSalvo.setAtivo(ativo);
        pacienteRepository.save(pacienteSalvo);
    }

    private Paciente buscarPessoaPeloCodigo(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }



}
