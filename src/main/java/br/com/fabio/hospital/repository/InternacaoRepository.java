package br.com.fabio.hospital.repository;


import br.com.fabio.hospital.model.Internacao;
import br.com.fabio.hospital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternacaoRepository extends JpaRepository<Internacao, Long> {

}