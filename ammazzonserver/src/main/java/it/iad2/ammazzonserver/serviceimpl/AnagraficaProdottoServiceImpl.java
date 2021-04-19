package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.repository.ProdottoRepository;
import it.iad2.ammazzonserver.service.AnagraficaProdottoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author Portatile
 */
@Service
public class AnagraficaProdottoServiceImpl implements AnagraficaProdottoService{
    @Autowired
    ProdottoRepository prodottoRepository;

    @Override
    public List<Prodotto> aggiungiProdotto(Prodotto prodotto) {
        prodottoRepository.save(prodotto);
        return aggiornaProdotto();
    }

    @Override
    public List<Prodotto> modificaProdotto(Prodotto prodotto) {
        prodottoRepository.save(prodotto);
        return aggiornaProdotto();
    }

    @Override
    public List<Prodotto> rimuoviProdotto(Prodotto prodotto) {
        prodottoRepository.delete(prodotto);
        return aggiornaProdotto();
    }

    @Override
    public List<Prodotto> aggiornaProdotto() {
        List<Prodotto> listaProdotti = prodottoRepository.findAll();
        return listaProdotti;
    }

    @Override
    public List<Prodotto> cercaProdotto(String cerca) {
        List<Prodotto> p = prodottoRepository.cercaLikeDescrizione(cerca);
        if (p == null) {
            p = new ArrayList<Prodotto>();
        }
        return p;
    }  

    @Override
    public Page<Prodotto> elementiPaginati(int numPage, int elemPage) {
        return prodottoRepository.trovaTuttiPaginati(PageRequest.of(numPage, elemPage));
    }
    
    
}
