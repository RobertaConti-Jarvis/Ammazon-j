package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.model.Prodotto;
import org.springframework.data.domain.Page;

public interface RicercaCatalogoService {

    Page<Prodotto> catalogoPaginati(String criterio, int numPage, int elemPage);
}
