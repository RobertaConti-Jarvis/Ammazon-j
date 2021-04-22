package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.Prodotto;
import org.springframework.data.domain.Page;


public interface MostraCarrelloService {
    Page<Prodotto> mostraCarrello(int numPag, int elemPag, Ordine ordine);
}
