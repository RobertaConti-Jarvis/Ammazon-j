package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Ordine;

public interface GestioneCarrelloService {
    
    Ordine aggiungiCarrello(ColoreTaglia ct, String token);
}
