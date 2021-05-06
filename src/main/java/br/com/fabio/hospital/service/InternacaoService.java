package br.com.fabio.hospital.service;

import br.com.fabio.hospital.exception.PacienteInexistenteOuInativaException;
import br.com.fabio.hospital.model.Internacao;
import br.com.fabio.hospital.model.Paciente;
import br.com.fabio.hospital.repository.InternacaoRepository;
import br.com.fabio.hospital.repository.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InternacaoService {
    private final InternacaoRepository internacaoRepository;
    private final PacienteRepository pacienteRepository;

    public InternacaoService(InternacaoRepository internacaoRepository, PacienteRepository pacienteRepository) {
        this.internacaoRepository = internacaoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public Internacao atualizar(Long id, Internacao internacao) {
        Internacao internacaoSalvo = internacaoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        BeanUtils.copyProperties(internacao, internacaoSalvo, "id");
        return internacaoRepository.save(internacaoSalvo);
    }

    private Internacao buscarPessoaPeloId(Long id) {
        return internacaoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }


    public Internacao salvar(Internacao internacao) {
        Optional<Paciente> paciente = pacienteRepository.findById(internacao.getPaciente().getId());

        if (paciente.isEmpty() || paciente.get().isInativo()) {
            throw new PacienteInexistenteOuInativaException();
        }
        return internacaoRepository.save(internacao);
    }
}
