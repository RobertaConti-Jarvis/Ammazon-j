package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.UtenteAnonimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteAnonimoRepository extends JpaRepository<UtenteAnonimo, Long>{
    
}
