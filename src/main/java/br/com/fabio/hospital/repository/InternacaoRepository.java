package br.com.fabio.hospital.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fabio.hospital.model.Internacao;
import br.com.fabio.hospital.repository.filter.FiltroInternacaoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface InternacaoRepository extends JpaRepository<Internacao, Long>, FiltroInternacaoRepository {


}