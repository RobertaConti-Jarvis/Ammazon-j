package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.ProdottoColore;
import it.iad2.ammazzonserver.model.VarianteColore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoColoreRepository extends JpaRepository<ProdottoColore, Long> {

    @Query("select pc from ProdottoColore pc"
            + " join pc.varianteColore c"
            + " join pc.prodotto p"
            + " where p.id = :id")
    List<ProdottoColore> trovaListaVarianteColoreProdotto(@Param("id") Long id);

    @Query("select vc from Prodotto p"
            + " join p.listaProdottoColore pc"
            + " join pc.varianteColore vc"
            + " where p.id=:id")
    List<VarianteColore> selezionaColoriAssociatiProdotto(@Param("id") Long id);

}
