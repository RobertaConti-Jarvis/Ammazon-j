package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import java.util.List;
import org.springframework.data.domain.Page;

public interface MostraCarrelloService {

    Page<Prodotto> mostraCarrello(int numPag, int elemPag, Ordine ordine);

    List<QtaOrdineVariante> mostaListaCarrello(Ordine ordine);
}
