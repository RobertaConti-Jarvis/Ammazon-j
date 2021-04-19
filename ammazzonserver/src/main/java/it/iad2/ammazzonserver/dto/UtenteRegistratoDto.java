/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.UtenteRegistrato;

/**
 *
 * @author utente
 */
public class UtenteRegistratoDto {
   UtenteRegistrato utenteRegistrato;

    public UtenteRegistratoDto() {
    }

    public UtenteRegistratoDto(UtenteRegistrato utenteRegistrato) {
        this.utenteRegistrato = utenteRegistrato;
    }

    public UtenteRegistrato getUtenteRegistrato() {
        return utenteRegistrato;
    }

    public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
        this.utenteRegistrato = utenteRegistrato;
    }

    @Override
    public String toString() {
        return "UtenteRegistratoDto{" + "utenteRegistrato=" + utenteRegistrato + '}';
    }
    

}
