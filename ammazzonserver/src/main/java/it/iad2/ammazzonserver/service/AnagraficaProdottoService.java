package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ProdottoDto;
import it.iad2.ammazzonserver.model.Prodotto;
import java.util.List;

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
}
