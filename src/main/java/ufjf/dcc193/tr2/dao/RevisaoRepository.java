package ufjf.dcc193.tr2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ufjf.dcc193.tr2.model.Avaliador;
import ufjf.dcc193.tr2.model.Revisao;
import ufjf.dcc193.tr2.model.Trabalho;

/**
 * RevisaoRepository
 */

@Repository
public interface RevisaoRepository extends JpaRepository<Revisao, Long>{

  @Query("SELECT r from Revisao r"
	+ " inner join Avaliador as a on r.avaliador.id = a.id "
	+ " where a.id = ?1 and r.status = 1")
	List<Revisao> findByAvaliador(Long long1);

	Revisao findFirstByAvaliadorAndTrabalho(Avaliador avaliador, Trabalho trabalho);
}