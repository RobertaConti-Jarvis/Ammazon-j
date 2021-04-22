package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.VarianteColore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteColoreRepository extends JpaRepository<VarianteColore, Long>{
    
     List<VarianteColore> findByCodiceContains(String criterio);
     
     @Query("Select vc from VarianteColore vc where vc.codice = :c or vc.descrizione like :d")
     List<VarianteColore> cercaColore(@Param("c") String ca, @Param("d") String da);
    
}
