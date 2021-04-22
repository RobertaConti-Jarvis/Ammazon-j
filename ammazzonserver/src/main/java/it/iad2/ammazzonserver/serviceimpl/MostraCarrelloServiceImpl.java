package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import it.iad2.ammazzonserver.repository.OrdineRepository;
import it.iad2.ammazzonserver.repository.QtaOrdineVarianteRepository;
import it.iad2.ammazzonserver.service.MostraCarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostraCarrelloServiceImpl implements MostraCarrelloService {

    @Autowired
    OrdineRepository ordineRepository;
    @Autowired
    QtaOrdineVarianteRepository qtaOrdineVarianteRepository;

    @Override
    public Page<QtaOrdineVariante> mostraCarrello(int numPag, int elemPag, Ordine ordine) {
       Page<QtaOrdineVariante> listaCarrello;
       listaCarrello = (Page<QtaOrdineVariante>) ordine.getListaQtaOrdineVariante();
       return listaCarrello;
    }
}
