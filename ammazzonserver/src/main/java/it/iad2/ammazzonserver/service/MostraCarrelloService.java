package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MostraCarrelloService {
    Page<QtaOrdineVariante> mostraCarrello(int numPag, int elemPag, Ordine ordine);
}
