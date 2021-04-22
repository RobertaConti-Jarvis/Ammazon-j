package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.Ordine;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long> {

    List<Ordine> findByStato(String stato, Sort sort);

    @Query("select o from Ordine o")
    Page<Ordine> elementiPaginatiReport(Pageable o);
    
    @Query("select max (numero) from Ordine")
    Integer findMaxNumeroOrdine();
}
