package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.dto.EsitoDto;
import it.iad2.ammazzonserver.dto.OrdineDto;
import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Ordine;

public interface GestioneCarrelloService {
    
    OrdineDto aggiungiCarrello(ColoreTaglia ct, String token);
    
    boolean esitoPagamento(Ordine ordine);
}
