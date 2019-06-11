package ufjf.dcc193.tr2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufjf.dcc193.tr2.model.AreaConhecimento;

/**
 * AreaConhecimentoRepository
 */
@Repository
public interface AreaConhecimentoRepository extends JpaRepository<AreaConhecimento, Long> {

}