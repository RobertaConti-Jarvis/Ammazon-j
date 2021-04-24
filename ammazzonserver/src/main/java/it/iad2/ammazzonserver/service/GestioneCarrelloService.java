package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.dto.OrdineDto;
import it.iad2.ammazzonserver.model.ColoreTaglia;

public interface GestioneCarrelloService {
    
    OrdineDto aggiungiCarrello(ColoreTaglia ct, String token);
}
