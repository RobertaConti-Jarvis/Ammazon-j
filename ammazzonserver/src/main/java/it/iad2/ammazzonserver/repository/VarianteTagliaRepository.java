package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.VarianteTaglia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteTagliaRepository extends JpaRepository<VarianteTaglia, Long>{
    
    List<VarianteTaglia> findByCodiceContains(String codice);
    
}
