package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import it.iad2.ammazzonserver.model.UtenteAnonimo;
import it.iad2.ammazzonserver.model.UtenteRegistrato;
import it.iad2.ammazzonserver.repository.ProdottoRepository;
import it.iad2.ammazzonserver.repository.QtaOrdineVarianteRepository;
import it.iad2.ammazzonserver.repository.UtenteAnonimoRepository;
import it.iad2.ammazzonserver.repository.UtenteRegistratoRepository;
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
    @Autowired
    UtenteAnonimoRepository utenteAnonimoRepository;
    @Autowired
    UtenteRegistratoRepository utenteRegistratoRepository;

    @Override
    public Page<Prodotto> mostraCarrello(int numPag, int elemPag, Ordine ordine) {
        return prodottoRepository.trovaProdottiOrdine(ordine.getId(), PageRequest.of(numPag, elemPag));
    }

    @Override
    public List<QtaOrdineVariante> mostaListaCarrello(String token) {
        UtenteRegistrato utenteReg = utenteRegistratoRepository.cercaUtenteRegistratoPerToken(token);
        UtenteAnonimo utenteAnon = utenteAnonimoRepository.cercaUtenteAnonimoPerToken(token);
        if (utenteReg != null && utenteReg.getOrdine() != null) {
            return utenteReg.getOrdine().getListaQtaOrdineVariante();
        } else if (utenteAnon != null && utenteAnon.getOrdine() != null) {
            return utenteAnon.getOrdine().getListaQtaOrdineVariante();
        }
        return null;
    }
}
