package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.VarianteColore;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteColoreRepository extends JpaRepository<VarianteColore, Long>{
    
     List<VarianteColore> findByCodiceContains(String criterio);
     
     @Query("Select vc from VarianteColore vc where vc.codice = :c or vc.descrizione like :d")
     //Page<VarianteColore> cercaColore(@Param("c") String ca, @Param("d") String da);
     List<VarianteColore> cercaColore(@Param("c") String ca, @Param("d") String da);
     
      @Query("select vc from VarianteColore vc")
    Page<VarianteColore> trovaTuttiPaginati(Pageable vc);
    
}
