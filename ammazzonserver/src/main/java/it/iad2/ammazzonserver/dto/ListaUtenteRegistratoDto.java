/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.UtenteRegistrato;
import java.util.List;

/**
 *
 * @author utente
 */
public class ListaUtenteRegistratoDto {
    List<UtenteRegistrato> listaUtenti;

    public ListaUtenteRegistratoDto(List<UtenteRegistrato> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    public ListaUtenteRegistratoDto() {
    }

    public List<UtenteRegistrato> getListaUtenti() {
        return listaUtenti;
    }

    public void setListaUtenti(List<UtenteRegistrato> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    @Override
    public String toString() {
        return "ListaUtenteRegistratoDto{" + "listaUtenti=" + listaUtenti + '}';
    }
    
}
