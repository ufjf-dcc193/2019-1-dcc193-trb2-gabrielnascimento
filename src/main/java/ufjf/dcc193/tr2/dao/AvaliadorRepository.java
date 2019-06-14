package ufjf.dcc193.tr2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufjf.dcc193.tr2.model.AreaConhecimento;
import ufjf.dcc193.tr2.model.Avaliador;

/**
 * AvaliadorRepository
 */

@Repository
public interface AvaliadorRepository extends JpaRepository<Avaliador, Long>{

    List<Avaliador> findByAreaConhecimento(AreaConhecimento areaConhecimento);

	Avaliador findFirstByEmailAndCodigoAcesso(String email, String codigoAcesso);
}