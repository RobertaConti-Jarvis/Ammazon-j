package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.UtenteRegistrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRegistratoRepository extends JpaRepository<UtenteRegistrato, Long>{
    
}
