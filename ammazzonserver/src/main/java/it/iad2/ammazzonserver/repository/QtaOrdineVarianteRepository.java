package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QtaOrdineVarianteRepository extends JpaRepository<QtaOrdineVariante, Long> {

    @Query("select q from QtaOrdineVariante where q.coloreTaglia = :coloreTaglia AND q.ordine= :ordine")
    QtaOrdineVariante cercaQtaOrdine(@Param("coloreTaglia") ColoreTaglia coloreTaglia, @Param("ordine") Ordine ordine);
}
