package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.ColoreTaglia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoreTagliaRepository extends JpaRepository<ColoreTaglia, Long>{
    
    @Query("select ct from ColoreTaglia ct"
            + " join ct.prodottoColore pc"
            + " join ct.varianteTaglia vt"
            + " where pc.id = :id")
    List<ColoreTaglia> trovaListaVarianteColoreProdotto(@Param("id") Long id);
}
