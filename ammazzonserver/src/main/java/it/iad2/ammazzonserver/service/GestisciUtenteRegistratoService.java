/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.UtenteRegistrato;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Samuele
 */
public interface GestisciUtenteRegistratoService {

    List<UtenteRegistrato> cercaUtenteRegistrato(String criterio);

    List<UtenteRegistrato> modificaUtenteRegistrato(UtenteRegistrato utente);

    List<UtenteRegistrato> aggiungiUtenteRegistrato(UtenteRegistrato utente);

    List<UtenteRegistrato> rimuoviUtenteRegistrato(UtenteRegistrato utente);

    List<UtenteRegistrato> aggiorna();

    Page<UtenteRegistrato> elementiPaginatiUtente(int numPage, int elemPage);

}
