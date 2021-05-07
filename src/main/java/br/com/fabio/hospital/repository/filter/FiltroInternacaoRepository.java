package br.com.fabio.hospital.repository.filter;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.com.fabio.hospital.model.Internacao;

public interface FiltroInternacaoRepository{
	public List<Internacao> findByFilter(LocalDate dataInicio, LocalDate dataFim) ;

}