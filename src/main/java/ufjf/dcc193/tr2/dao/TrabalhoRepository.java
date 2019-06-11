package ufjf.dcc193.tr2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufjf.dcc193.tr2.model.Trabalho;

/**
 * TrabalhoRepository
 * 
 */

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    
}