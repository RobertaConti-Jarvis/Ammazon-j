package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.ProdottoColore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoColoreRepository extends JpaRepository<ProdottoColore, Long>{
    
}
