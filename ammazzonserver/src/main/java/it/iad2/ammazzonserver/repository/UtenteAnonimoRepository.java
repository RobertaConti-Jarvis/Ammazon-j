package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.UtenteAnonimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteAnonimoRepository extends JpaRepository<UtenteAnonimo, Long> {

    @Query("select u from UtenteAnonimo u where u.tokenAnonimo = :token")
    UtenteAnonimo cercaUtenteAnonimoPerToken(@Param("token") String token);
}
