package br.com.fabio.hospital.repository;


import br.com.fabio.hospital.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository extends CrudRepository<Especialidade, Long> {

}