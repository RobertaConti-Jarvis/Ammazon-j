package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.ListaQtaOrdineVarianteDto;
import it.iad2.ammazzonserver.dto.OrdineDto;
import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import it.iad2.ammazzonserver.model.TotaleOrdine;
import it.iad2.ammazzonserver.model.UtenteAnonimo;
import it.iad2.ammazzonserver.model.UtenteRegistrato;
import it.iad2.ammazzonserver.repository.ColoreTagliaRepository;
import it.iad2.ammazzonserver.repository.OrdineRepository;
import it.iad2.ammazzonserver.repository.ProdottoRepository;
import it.iad2.ammazzonserver.repository.QtaOrdineVarianteRepository;
import it.iad2.ammazzonserver.repository.UtenteAnonimoRepository;
import it.iad2.ammazzonserver.repository.UtenteRegistratoRepository;
import it.iad2.ammazzonserver.service.GestioneCarrelloService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestioneCarrelloServiceImpl implements GestioneCarrelloService {

    final Logger logger = LoggerFactory.getLogger(GestioneTaglieServiceImpl.class);

    @Autowired
    UtenteRegistratoRepository utenteRegistratoRepository;

    @Autowired
    UtenteAnonimoRepository utenteAnonimoRepository;

    @Autowired
    OrdineRepository ordineRepository;

    @Autowired
    QtaOrdineVarianteRepository qtaOrdineVarianteRepository;

    @Autowired
    ProdottoRepository prodottoRepository;

    @Autowired
    ColoreTagliaRepository coloreTagliaRepository;

    @Override
    public OrdineDto aggiungiCarrello(ColoreTaglia ct, String token) {
        //controllo se il token è null altrimenti lo creo 
        UtenteAnonimo ua;
        Ordine ordine;
        if (token == null) {
            token = UUID.randomUUID().toString().toUpperCase();
            ordine = new Ordine();
            ordine.setNumero(ordineRepository.findMaxNumeroOrdine() + 1);
            ordine.setData(LocalDate.now());
            ordine = ordineRepository.save(ordine);
            ua = new UtenteAnonimo(token);
            ua.setOrdine(ordine);
            ua = utenteAnonimoRepository.save(ua);
            logger.debug("#caso token null");
        } else {
            //recupero identità utente dal token
            ua = utenteAnonimoRepository.cercaUtenteAnonimoPerToken(token);
            if (ua != null) {
                ordine = ordineRepository.findOrdineDaUtenteAnonimo(ua);
                token = ua.getTokenAnonimo();
                logger.debug("#utente anonimo non null");
            } else {
                ua = utenteRegistratoRepository.cercaUtenteRegistratoPerToken(token);
                ordine = ordineRepository.findOrdineDaUtenteRegistrato((UtenteRegistrato) ua);
                if (ordine == null) {
                    ordine = new Ordine();
                }
                token = ordine.getUtenteRegistrato().getTokenRegistrato();
                logger.debug("#utente registrato");
            }
        }
        QtaOrdineVariante qta;
        //controllo che il prodotto non sia già stato aggiunto in QtaOrdineVariante, 
        //se esiste aggiungo 1 alla quantità, altrimenti creo l'associazione
        if (ordine.getId() != null) {
            qta = qtaOrdineVarianteRepository.cercaQtaOrdine(ct, ordine);
            logger.debug("#ordine esistente" + ordine.getId());
            if (qta != null) {
                qta.setQta(qta.getQta() + 1);
            } else {
                qta = new QtaOrdineVariante(1);
                qta.setColoreTaglia(ct);
                qta.setOrdine(ordine);
                qta = qtaOrdineVarianteRepository.save(qta);
            }
            logger.debug("#qta = " + qta.getQta());
        } else {
            ordine = new Ordine();
            ordine.setNumero(ordineRepository.findMaxNumeroOrdine() + 1);
            ordine.setData(LocalDate.now());
            qta = new QtaOrdineVariante(1);
            qta.setColoreTaglia(ct);
            logger.debug("#ordine nuovo");
        }
        if (ua instanceof UtenteAnonimo) {
            ordine.setUtenteAnonimo(ua);
        } else {
            ordine.setUtenteRegistrato((UtenteRegistrato) ua);
        }
        logger.debug("id utente: " + ua.getId());
        ordine.getListaQtaOrdineVariante().add(qta);
        ordine = ordineRepository.save(ordine);
        logger.debug("#id ordine salvato" + ordine.getId());
        qta.setOrdine(ordine);
        qtaOrdineVarianteRepository.save(qta);
        int numElementi = ordine.getListaQtaOrdineVariante().size();
        logger.debug("#num elementi" + numElementi);
        OrdineDto ordineDto = new OrdineDto(ordine, numElementi, token);
        return ordineDto;
    }

    @Override
    public boolean esitoPagamento(Ordine ordine) {

        Random r = new Random();
        boolean esito = r.nextBoolean();
        if (esito == true) {
            ordine.setId(ordineRepository.findMaxNumeroOrdine().longValue());
            ordine.setStato("Pagato");
        } else {
            ordine.setId(ordineRepository.findMaxNumeroOrdine().longValue());
            ordine.setStato("Non Pagato");
        }
        return esito;
    }

    @Override
    @Transactional
    public ListaQtaOrdineVarianteDto rimuoviElemento(QtaOrdineVariante qov) {
        //Si fa una verifica nel db per aggiornare le entità nel caso siano state modificate 
        qov = qtaOrdineVarianteRepository.findById(qov.getId()).get();
        logger.debug("qov: " + qov.getId());
        Ordine ordine =  qtaOrdineVarianteRepository.cercaOrdine(qov.getOrdine());
       // logger.debug("#ordine id: " + ordine.getId());
        ColoreTaglia coloreTaglia = qov.getColoreTaglia();
        coloreTaglia = coloreTagliaRepository.findById(qov.getColoreTaglia().getId()).get();
        logger.debug("ColoreTaglia id: " + coloreTaglia.getId());

        //Si cancellano l'entità aggiornata dal db;
        qtaOrdineVarianteRepository.delete(qov);
       // coloreTagliaRepository.delete(coloreTaglia);
        //Si crea una nuova lista senza il record già rimosso
        List<QtaOrdineVariante> listaQov = new ArrayList<>();
        qtaOrdineVarianteRepository.findAll().stream().filter(qto -> (qto.getOrdine() == ordine)).forEachOrdered(qto -> {
            listaQov.add(qto);
        });
        //Si aggiorna l'ordine e si salva nel db senza il record rimosso
        ordine.setListaQtaOrdineVariante(listaQov);
        ordineRepository.save(ordine);
        return new ListaQtaOrdineVarianteDto(listaQov);

    }

    @Override
    public OrdineDto calcolaTotaleOrdine(String token) {
        List<TotaleOrdine> listaTotaleOrdine = prodottoRepository.recuperaTotaleOrdine(token);
        Double totale;
        totale = listaTotaleOrdine.stream()
                .mapToDouble(t -> t.getTotale())
                .sum();
        OrdineDto dto = new OrdineDto();
        dto.setSessionToken(token);
        dto.setTotale(totale);
        return dto;
    }

}
