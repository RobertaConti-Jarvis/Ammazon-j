/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.UtenteRegistrato;
import it.iad2.ammazzonserver.repository.UtenteRegistratoRepository;
import it.iad2.ammazzonserver.service.GestisciUtenteRegistratoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Samuele
 */
@Service
public class GestisciUtenteRegistratoServiceImpl implements GestisciUtenteRegistratoService {

    @Autowired
    UtenteRegistratoRepository utenteRegistratoRepository;

    @Override
    public List<UtenteRegistrato> cercaUtenteRegistrato(String criterio) {
        return utenteRegistratoRepository.findByUsernameContains(criterio);
    }

    @Override
    public List<UtenteRegistrato> modificaUtenteRegistrato(UtenteRegistrato utente) {
        return aggiungiUtenteRegistrato(utente);
    }

    @Override
    public List<UtenteRegistrato> rimuoviUtenteRegistrato(UtenteRegistrato utente) {
        utenteRegistratoRepository.delete(utente);
        return aggiorna();
    }

    @Override
    public List<UtenteRegistrato> aggiorna() {
        return utenteRegistratoRepository.findAll();
    }

    @Override
    public List<UtenteRegistrato> aggiungiUtenteRegistrato(UtenteRegistrato utente) {
        utenteRegistratoRepository.save(utente);
        return aggiorna();
    }

}
