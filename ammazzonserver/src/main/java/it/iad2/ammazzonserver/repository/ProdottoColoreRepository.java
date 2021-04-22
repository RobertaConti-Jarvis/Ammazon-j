package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.Prodotto;
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

    @Query("select pc from ProdottoColore pc"
            + " join pc.prodotto p"
            + " join pc. varianteColore vc"
            + " where p.id = :id1 and vc.id =:id2")
    ProdottoColore disassociaProdottoColore(@Param("id1") Long id, @Param("id2") Long id1);

    @Query("select vc from VarianteColore vc "
            + "where vc not in "
            + " (select vc from Prodotto p"
            + " join p.listaProdottoColore pc"
            + " join pc.varianteColore vc"
            + " where p.id=:id)")
    List<VarianteColore> selezionaColoriNonAssociatiProdotto(@Param("id") Long id);
    
    
    
                
      
    
           
    
       
   
 

}
