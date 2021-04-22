package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.UtenteAnonimo;
import it.iad2.ammazzonserver.model.UtenteRegistrato;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRegistratoRepository extends JpaRepository<UtenteRegistrato, Long> {

    List<UtenteRegistrato> findByUsernameContains(String criterio);

    @Query("select u from UtenteRegistrato u")
    Page<UtenteRegistrato> elementiPaginatiUtente(Pageable p);

    @Query("select u from UtenteRegistrato u "
            + "where u.username = :username")
    UtenteRegistrato findUsername(@Param("username") String username);

    @Query("select u from UtenteRegistrato u where u.tokenRegistrato = :token")
    UtenteRegistrato cercaUtenteRegistratoPerToken(@Param("token") String token);
    
    @Query("select u from UtenteRegistrato u "
            + "where u.email = :email")
    UtenteRegistrato findEmail(@Param("email") String email);
}
