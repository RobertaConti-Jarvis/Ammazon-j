/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.*;
import it.iad2.ammazzonserver.service.GestisciUtenteRegistratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author utente
 */
@RestController
@CrossOrigin("*")
public class GestioneUtenteRegistratoController {

    @Autowired
    GestisciUtenteRegistratoService gestisciUtenteRegistratoService;

    @RequestMapping("/ricerca-utente")
    @ResponseBody
    public ListaUtenteRegistratoDto cercaUtente(@RequestBody CriterioRicercaDto dto) {
        return new ListaUtenteRegistratoDto(gestisciUtenteRegistratoService.cercaUtenteRegistrato(dto.getCriterio()));
    }

    @RequestMapping("/modifica-utente")
    @ResponseBody
    public ListaUtenteRegistratoDto modificaUtente(@RequestBody UtenteRegistratoDto dto) {
        return new ListaUtenteRegistratoDto(gestisciUtenteRegistratoService.modificaUtenteRegistrato(dto.getUtenteRegistrato()));
    }

    @RequestMapping("/rimuovi-utente")
    @ResponseBody
    public ListaUtenteRegistratoDto rimuoviUtente(@RequestBody UtenteRegistratoDto dto) {
        return new ListaUtenteRegistratoDto(gestisciUtenteRegistratoService.rimuoviUtenteRegistrato(dto.getUtenteRegistrato()));
    }

    @RequestMapping("/aggiungi-utente")
    @ResponseBody
    public ListaUtenteRegistratoDto aggiungiUtente(@RequestBody UtenteRegistratoDto dto) {
        return new ListaUtenteRegistratoDto(gestisciUtenteRegistratoService.aggiungiUtenteRegistrato(dto.getUtenteRegistrato()));
    }

    @RequestMapping("/aggiorna-utente")
    @ResponseBody
    public ListaUtenteRegistratoDto aggiornaUtente() {
        return new ListaUtenteRegistratoDto(gestisciUtenteRegistratoService.aggiorna());
    }

    @RequestMapping("/carica-utenti-paginati")
    @ResponseBody
    PageUtenteDto caricaUtentiPage(@RequestBody DatiPageDto dto){
        return new PageUtenteDto(gestisciUtenteRegistratoService.elementiPaginatiUtente(dto.getNumPag(),dto.getElemPag()));
    }
}
