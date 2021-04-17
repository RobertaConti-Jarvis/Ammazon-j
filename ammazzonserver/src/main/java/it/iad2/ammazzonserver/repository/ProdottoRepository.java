package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.Prodotto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long>{
    
    List<Prodotto> findByCodiceEqualsOrDescrizioneLike(String c, String d);
}
