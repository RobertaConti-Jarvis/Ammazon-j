package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.model.Prodotto;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Portatile
 */
public interface AnagraficaProdottoService {

    /**
     * Salva i dati di un nuovo prodotto in archivio.
     *
     * @param prodotto ...
     * @return lista dei prodotti presenti in archivio
     */
    List<Prodotto> aggiungiProdotto(Prodotto Prodotto);

    List<Prodotto> modificaProdotto(Prodotto prodotto);

    List<Prodotto> rimuoviProdotto(Prodotto prodotto);

    List<Prodotto> aggiornaProdotto();

    List<Prodotto> cercaProdotto(String cerca);
    
    Page<Prodotto> elementiPaginati(int numPage, int elemPage);
}
