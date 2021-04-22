package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.service.GestioneCarrelloService;

public class GestioneCarrelloServiceImpl implements GestioneCarrelloService{

    @Override
    public Ordine aggiungiCarrello(ColoreTaglia ct, String token) {
        //recupero identità utente dal token
        
        //controllo che l'ordine esista altrimenti crearlo
        
        //controllo che il prodotto non sia già stato aggiunto in QtaOrdineVariante, 
        //se esiste aggiungo 1 alla quantità, altrimenti creo l'associazione
        
        //salvo la QtaOrdineVariante 
        
        //aggiungo QtaOrdineVariante all'ordine e lo salvo 
        
        return null;
    }

}
