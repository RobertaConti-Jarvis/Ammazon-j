package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.VarianteColore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteColoreRepository extends JpaRepository<VarianteColore, Long>{
    
     List<VarianteColore> findByCodiceContains(String criterio);
    
}
