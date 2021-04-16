package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QtaOrdineVarianteRepository extends JpaRepository<QtaOrdineVariante, Long>{
    
}
