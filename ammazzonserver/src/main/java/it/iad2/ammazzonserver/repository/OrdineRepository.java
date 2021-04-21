package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.Ordine;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long>{


    List<Ordine> findByStato(String stato, Sort sort);
}
