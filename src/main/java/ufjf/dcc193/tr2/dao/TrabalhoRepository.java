package ufjf.dcc193.tr2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ufjf.dcc193.tr2.model.AreaConhecimento;
import ufjf.dcc193.tr2.model.Trabalho;

/**
 * TrabalhoRepository
 * 
 */

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    List<Trabalho> findByAreaConhecimento(AreaConhecimento areaConhecimento);

    @Query("SELECT t from Trabalho t"
	+ " inner join Revisao as r on r.trabalho.id = t.id "
	+ " inner join Avaliador as a on r.avaliador.id = a.id "
	+ " where a.id = ?1 and t.areaConhecimento.id = ?2 and r.status = 1")
	List<Trabalho> findByIdAvalaliadorAndIdAreaConhecimentoOrderByStatus(Long id, Long id2);
}