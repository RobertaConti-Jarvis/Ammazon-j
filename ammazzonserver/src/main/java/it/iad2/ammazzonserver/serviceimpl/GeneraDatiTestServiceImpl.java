/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.ProdottoColore;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import it.iad2.ammazzonserver.model.UtenteAnonimo;
import it.iad2.ammazzonserver.model.UtenteRegistrato;
import it.iad2.ammazzonserver.model.VarianteColore;
import it.iad2.ammazzonserver.model.VarianteTaglia;
import it.iad2.ammazzonserver.repository.ColoreTagliaRepository;
import it.iad2.ammazzonserver.repository.OrdineRepository;
import it.iad2.ammazzonserver.repository.ProdottoColoreRepository;
import it.iad2.ammazzonserver.repository.ProdottoRepository;
import it.iad2.ammazzonserver.repository.QtaOrdineVarianteRepository;
import it.iad2.ammazzonserver.repository.UtenteAnonimoRepository;
import it.iad2.ammazzonserver.repository.UtenteRegistratoRepository;
import it.iad2.ammazzonserver.repository.VarianteColoreRepository;
import it.iad2.ammazzonserver.repository.VarianteTagliaRepository;
import it.iad2.ammazzonserver.service.GeneraDatiTestService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matte
 */
@Service
public class GeneraDatiTestServiceImpl implements GeneraDatiTestService {

    @Autowired
    OrdineRepository ordineRepository;
    @Autowired
    ProdottoColoreRepository prodottoColoreRepository;
    @Autowired
    ProdottoRepository prodottoRepository;
    @Autowired
    QtaOrdineVarianteRepository qtaOrdineVarianteRepository;
    @Autowired
    ColoreTagliaRepository coloreTagliaRepository;
    @Autowired
    UtenteAnonimoRepository utenteAnonimoRepository;
    @Autowired
    UtenteRegistratoRepository utenteRegistratoRepository;
    @Autowired
    VarianteColoreRepository varianteColoreRepository;
    @Autowired
    VarianteTagliaRepository varianteTagliaRepository;

    @Override
    public void generaDatiTest() {

        //ripulisco il DB
        disassociaUtente();
        qtaOrdineVarianteRepository.deleteAllInBatch();
        ordineRepository.deleteAllInBatch();
        utenteAnonimoRepository.deleteAllInBatch();
        utenteRegistratoRepository.deleteAllInBatch();
        coloreTagliaRepository.deleteAllInBatch();
        prodottoColoreRepository.deleteAllInBatch();
        prodottoRepository.deleteAllInBatch();
        varianteColoreRepository.deleteAllInBatch();
        varianteTagliaRepository.deleteAllInBatch();

        //creo tutte le entità
        for (int i = 0; i < 50; i++) {
            Prodotto p = new Prodotto("codice " + i, "prodotto " + i, i * 1.5);
            prodottoRepository.save(p);
        }
        for (int i = 0; i < 50; i++) {
            UtenteAnonimo u = new UtenteAnonimo("token " + i);
            utenteAnonimoRepository.save(u);

        }
        for (int i = 0; i < 50; i++) {
            UtenteRegistrato u = new UtenteRegistrato("nome " + i, "cognome " + i, "username " + i, "password " + i, "Cod.Fiscale " + i, "tokenRegistrato " + i);
            utenteRegistratoRepository.save(u);
        }
        for (int i = 0; i < 41; i++) {
            Ordine o = new Ordine(LocalDate.now(), i);
            ordineRepository.save(o);
        }
        for (int i = 0; i < 41; i++) {
            QtaOrdineVariante o = new QtaOrdineVariante(i);
            qtaOrdineVarianteRepository.save(o);
        }
        for (int i = 0; i < 20; i++) {
            ProdottoColore pc = new ProdottoColore();
            prodottoColoreRepository.save(pc);
        }
        for (int i = 0; i < 30; i++) {
            ColoreTaglia c = new ColoreTaglia(i);
            coloreTagliaRepository.save(c);
        }
        for (int i = 0; i < 20; i++) {
            VarianteColore vc = new VarianteColore("codice " + i, "descrizione" + i);
            varianteColoreRepository.save(vc);
        }
        for (int i = 0; i < 20; i++) {
            VarianteTaglia vt = new VarianteTaglia("codice " + i);
            varianteTagliaRepository.save(vt);
        }
        //associo prodotti a prodottoColore
        List<Prodotto> prodotti = prodottoRepository.findAll().subList(0, 20);
        List<ProdottoColore> prodottoColore = prodottoColoreRepository.findAll().subList(0, 20);
        prodotti.forEach(p -> {
            p.setListaProdottoColore(prodottoColore);
            prodottoColore.forEach(pc -> {
                pc.setProdotto(p);
                prodottoColoreRepository.save(pc);
            });
            prodottoRepository.save(p);
        });

        //Associo ordine a utente anonimo
        List<Ordine> ordini = ordineRepository.findAll().subList(0, 20);
        List<UtenteAnonimo> utenteAnonimo = utenteAnonimoRepository.findAll().subList(0, 20);
        int i = 0;
        for (UtenteAnonimo utenteAnonimo1 : utenteAnonimo) {
            utenteAnonimo1.setOrdine(ordini.get(i++));
            utenteAnonimoRepository.save(utenteAnonimo1);
        }
        i = 0;
        for (Ordine ordine : ordini) {
            ordine.setUtenteAnonimo(utenteAnonimo.get(i++));
            ordineRepository.save(ordine);
        }
        //Associo ordine a utente regitstrato 
        List<Ordine> ordine1 = ordineRepository.findAll().subList(21, 41);
        List<UtenteRegistrato> utenteRegistrato = utenteRegistratoRepository.findAll().subList(0, 20);
        i = 0;
        for (UtenteRegistrato utenteRegistrato1 : utenteRegistrato) {
            utenteRegistrato1.setOrdine(ordine1.get(i++));
            utenteRegistratoRepository.save(utenteRegistrato1);
        }
        i = 0;
        for (Ordine ordine : ordini) {
            ordine.setUtenteRegistrato(utenteRegistrato.get(i++));
            ordineRepository.save(ordine);
        }
        //associo QtaOrdiniVariante con ordine
        List<QtaOrdineVariante> listaQuantita = qtaOrdineVarianteRepository.findAll().subList(0, 20);
        List<QtaOrdineVariante> listaQuantita1 = qtaOrdineVarianteRepository.findAll().subList(21, 41);
        ordini.forEach(g -> {
            g.setListaQtaOrdineVariante(listaQuantita);
            ordineRepository.save(g);
        });
        i = 0;
        for (QtaOrdineVariante qtaOrdineVariante : listaQuantita) {
            qtaOrdineVariante.setOrdine(ordini.get(i++));
            qtaOrdineVarianteRepository.save(qtaOrdineVariante);
        }
        ordine1.forEach(g -> {
            g.setListaQtaOrdineVariante(listaQuantita1);
            ordineRepository.save(g);
        });
        i = 0;
        for (QtaOrdineVariante qtaOrdineVariante : listaQuantita1) {
            qtaOrdineVariante.setOrdine(ordine1.get(i++));
            qtaOrdineVarianteRepository.save(qtaOrdineVariante);
        }
        //associo coloreTaglia a QtaOrdineVariabile
        List<ColoreTaglia> listaColoreTaglia = coloreTagliaRepository.findAll().subList(0, 20);
        listaColoreTaglia.forEach(l -> {
            l.setListaQtaOrdineVariante(listaQuantita);
            coloreTagliaRepository.save(l);
        });
        i = 0;
        for (QtaOrdineVariante ordineVariante : listaQuantita) {
            ordineVariante.setColoreTaglia(listaColoreTaglia.get(i++));
            qtaOrdineVarianteRepository.save(ordineVariante);
        }
        //Associo ProdottoCOlore con ColoreTaglia
        List<ProdottoColore> listaProdottoColore = prodottoColoreRepository.findAll().subList(0, 20);
        listaProdottoColore.forEach(c -> {
            c.setListaColoreTaglia(listaColoreTaglia);
            prodottoColoreRepository.save(c);
        });
        i = 0;
        for (ColoreTaglia coloreTaglia : listaColoreTaglia) {
            coloreTaglia.setProdottoColore(prodottoColore.get(i++));
            coloreTagliaRepository.save(coloreTaglia);
        }
        //Associo variante colore a prodotto colore
        List<VarianteColore> listaVarianteColore = varianteColoreRepository.findAll().subList(0, 20);
        listaVarianteColore.forEach(c -> {
            c.setListaProdottoColore(listaProdottoColore);
            varianteColoreRepository.save(c);
        });
        i = 0;
        for (ProdottoColore prodottoColore1 : listaProdottoColore) {
            prodottoColore1.setVarianteColore(listaVarianteColore.get(i++));
            prodottoColoreRepository.save(prodottoColore1);
        }
        //Associo VaraianteTaglia a ColoreTaglia
        List<VarianteTaglia> listaVarianteTaglia = varianteTagliaRepository.findAll().subList(0, 20);
        listaVarianteTaglia.forEach(h -> {
            h.setListaColoreTaglia(listaColoreTaglia);
            varianteTagliaRepository.save(h);
        });
        i = 0;
        for (ColoreTaglia coloreTaglia : listaColoreTaglia) {
            coloreTaglia.setVarianteTaglia(listaVarianteTaglia.get(i++));
            coloreTagliaRepository.save(coloreTaglia);
        }

    }

    //disassocio tutti gli utenti con gli ordini
    @Override
    public void disassociaUtente() {
        List<Ordine> ordiniDel = ordineRepository.findAll();
        ordiniDel.forEach(s -> {
            s.setUtenteAnonimo(null);
            s.setUtenteRegistrato(null);
            ordineRepository.save(s);
        });
        List<UtenteAnonimo> utentiA = utenteAnonimoRepository.findAll();
        utentiA.forEach(u -> {
            u.setOrdine(null);
            utenteAnonimoRepository.save(u);
        });
        List<UtenteRegistrato> utentiR = utenteRegistratoRepository.findAll();
        utentiR.forEach(ur -> {
            ur.setOrdine(null);
            utenteRegistratoRepository.save(ur);
        });
    }
}
