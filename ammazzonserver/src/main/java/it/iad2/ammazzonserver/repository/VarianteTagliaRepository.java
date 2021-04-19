package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.ProdottoColore;
import it.iad2.ammazzonserver.model.VarianteTaglia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteTagliaRepository extends JpaRepository<VarianteTaglia, Long> {

    List<VarianteTaglia> findByCodiceContains(String codice);

    @Query(
            "select vt from VarianteTaglia vt "
            + " where vt not in "
            + " (select ct.varianteTaglia from ColoreTaglia ct where ct.prodottoColore= :pc)")
    List<VarianteTaglia> trovaTaglieNonAssociate(@Param("pc") ProdottoColore prodottoColore);
}
