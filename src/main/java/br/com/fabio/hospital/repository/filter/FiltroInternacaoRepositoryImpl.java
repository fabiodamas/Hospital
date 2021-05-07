package br.com.fabio.hospital.repository.filter;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.fabio.hospital.model.Internacao;

public class  FiltroInternacaoRepositoryImpl implements FiltroInternacaoRepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Internacao> findByFilter(LocalDate dataInicio, LocalDate dataFim) {
		StringBuilder sb = new StringBuilder();
		sb.append("select i ");
		sb.append("from Internacao i ");
		sb.append("where i.dataInternacao >= :dataInicio ");

		if (dataFim != null) {
			sb.append("and i.dataInternacao <= :dataFim ");			
		}
		
		Query query = entityManager.createQuery(sb.toString());
		query.setParameter("dataInicio", dataInicio);

		if (dataFim != null) {
			query.setParameter("dataFim", dataFim);			
		}

		return  query.getResultList();	
	}
	
}