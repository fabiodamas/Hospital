package br.com.fabio.hospital.service;

import br.com.fabio.hospital.model.Internacao;
import br.com.fabio.hospital.repository.InternacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class InternacaoService {
    private final InternacaoRepository internacaoRepository;

    public InternacaoService(InternacaoRepository internacaoRepository) {
        this.internacaoRepository = internacaoRepository;
    }

    public Internacao atualizar(Long id, Internacao internacao) {
        Internacao internacaoSalvo = internacaoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        BeanUtils.copyProperties(internacao, internacaoSalvo, "id");
        return internacaoRepository.save(internacaoSalvo);
    }

    private Internacao buscarPessoaPeloId(Long id) {
        return internacaoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }



}
