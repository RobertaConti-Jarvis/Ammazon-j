package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.repository.ProdottoRepository;
import it.iad2.ammazzonserver.service.MostraCarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class MostraCarrelloServiceImpl implements MostraCarrelloService {

    @Autowired
    ProdottoRepository prodottoRepository;   
    
    @Override
    public Page<Prodotto> mostraCarrello(int numPag, int elemPag, Ordine ordine) {
       return prodottoRepository.trovaProdottiOrdine(ordine.getId(), PageRequest.of(numPag, elemPag));
    }
}
