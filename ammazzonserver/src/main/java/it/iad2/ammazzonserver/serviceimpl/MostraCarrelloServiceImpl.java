package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import it.iad2.ammazzonserver.repository.OrdineRepository;
import it.iad2.ammazzonserver.repository.ProdottoRepository;
import it.iad2.ammazzonserver.repository.QtaOrdineVarianteRepository;
import it.iad2.ammazzonserver.service.MostraCarrelloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MostraCarrelloServiceImpl implements MostraCarrelloService {

    @Autowired
    ProdottoRepository prodottoRepository;
    @Autowired
    QtaOrdineVarianteRepository qtaOrdineVarianteRepository;

    @Override
    public Page<Prodotto> mostraCarrello(int numPag, int elemPag, Ordine ordine) {
        return prodottoRepository.trovaProdottiOrdine(ordine.getId(), PageRequest.of(numPag, elemPag));
    }

    @Override
    public List<QtaOrdineVariante> mostaListaCarrello(Ordine ordine) {
        return qtaOrdineVarianteRepository.findByordine(ordine.getId());
    }
}
