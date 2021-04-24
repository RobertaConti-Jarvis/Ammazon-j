package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.OrdineDto;
import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import it.iad2.ammazzonserver.model.UtenteAnonimo;
import it.iad2.ammazzonserver.model.UtenteRegistrato;
import it.iad2.ammazzonserver.repository.OrdineRepository;
import it.iad2.ammazzonserver.repository.QtaOrdineVarianteRepository;
import it.iad2.ammazzonserver.repository.UtenteAnonimoRepository;
import it.iad2.ammazzonserver.repository.UtenteRegistratoRepository;
import it.iad2.ammazzonserver.service.GestioneCarrelloService;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestioneCarrelloServiceImpl implements GestioneCarrelloService {

    @Autowired
    UtenteRegistratoRepository utenteRegistratoRepository;

    @Autowired
    UtenteAnonimoRepository utenteAnonimoRepository;

    @Autowired
    OrdineRepository ordineRepository;

    @Autowired
    QtaOrdineVarianteRepository qtaOrdineVarianteRepository;

    @Override
    public OrdineDto aggiungiCarrello(ColoreTaglia ct, String token) {
        //controllo se il token è null altrimenti lo creo 
        UtenteAnonimo ua;
        Ordine ordine;
        if (token == null) {
            token = UUID.randomUUID().toString().toUpperCase();
            ua = new UtenteAnonimo(token);
            ua = utenteAnonimoRepository.save(ua);
            ordine = new Ordine();
        } else {
            //recupero identità utente dal token
            ua = utenteAnonimoRepository.cercaUtenteAnonimoPerToken(token);
            ordine = ordineRepository.findOrdineDaUtenteAnonimo(ua);
            if(ua != null){
                token = ua.getTokenAnonimo();
            }else if (ua == null) {
                ua = utenteRegistratoRepository.cercaUtenteRegistratoPerToken(token);
                ordine = ordineRepository.findOrdineDaUtenteRegistrato((UtenteRegistrato)ua);
                token = ordine.getUtenteRegistrato().getTokenRegistrato();
            }
        }
        QtaOrdineVariante qta;
        //controllo che il prodotto non sia già stato aggiunto in QtaOrdineVariante, 
        //se esiste aggiungo 1 alla quantità, altrimenti creo l'associazione
        if (ordine != null) {
            qta = qtaOrdineVarianteRepository.cercaQtaOrdine(ct, ordine);
            if (qta != null) {
                qta.setQta(qta.getQta() + 1);
            } else {
                qta.setQta(1);
            }
        } else {
            ordine = new Ordine();
            ordine.setNumero(ordineRepository.findMaxNumeroOrdine() + 1);
            ordine.setData(LocalDate.now());
            qta = new QtaOrdineVariante(1);
            qta.setColoreTaglia(ct);
            if (ua instanceof UtenteAnonimo) {
                ordine.setUtenteAnonimo(ua);
            } else {
                ordine.setUtenteRegistrato((UtenteRegistrato) ua);
            }
        }
        ordine.getListaQtaOrdineVariante().add(qta);
        ordine = ordineRepository.save(ordine);
        qta.setOrdine(ordine);
        qtaOrdineVarianteRepository.save(qta);
        return new OrdineDto(ordine, token);
    }

}