package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.Prodotto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long>{
    
    //List<Prodotto> findByCodiceEqualsOrDescrizioneLike(String c, String d);
    @Query("select p from Prodotto p where p.codice= :c or p.descrizione like %:d%")
    List<Prodotto> cercaEqualsCodiceLikeDescrizione(@Param("c") String c, @Param("d") String d);
    
    @Query("select p from Prodotto p where p.descrizione like %:criterio%")
    List<Prodotto> cercaLikeDescrizione(@Param("criterio") String criterio);
    
    @Query("select p from Prodotto p")
    Page<Prodotto> trovaTuttiPaginati(Pageable p);
}
