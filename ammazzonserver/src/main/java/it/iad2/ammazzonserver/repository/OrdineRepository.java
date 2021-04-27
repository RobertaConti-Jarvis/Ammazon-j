package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import it.iad2.ammazzonserver.model.UtenteAnonimo;
import it.iad2.ammazzonserver.model.UtenteRegistrato;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long> {

    List<Ordine> findByStato(String stato, Sort sort);

    @Query("select o from Ordine o")
    Page<Ordine> elementiPaginatiReport(Pageable o);

    @Query("select max (numero) from Ordine")
    Integer findMaxNumeroOrdine();

    @Query("select o from Ordine o join o.utenteAnonimo where o.utenteAnonimo = :ua")
    Ordine findOrdineDaUtenteAnonimo(@Param("ua") UtenteAnonimo ua);

    @Query("select o from Ordine o join o.utenteRegistrato where o.utenteRegistrato = :ur and o.stato = 'CARRELLO'")
    Ordine findOrdineDaUtenteRegistrato(@Param("ur") UtenteRegistrato ur);

//    @Query("select qo from Ordine o join o.qtaOrdineVariante qo where o.id = :id ")
//    List<QtaOrdineVariante> findProdottiCarrello(@Param("id") Long id);
}
// Ordine - 