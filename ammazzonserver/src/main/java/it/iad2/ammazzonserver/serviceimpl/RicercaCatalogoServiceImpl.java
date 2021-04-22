package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.repository.ProdottoRepository;
import it.iad2.ammazzonserver.service.RicercaCatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RicercaCatalogoServiceImpl implements RicercaCatalogoService {

    @Autowired
    ProdottoRepository prodottoRepository;

    @Override
    public Page<Prodotto> catalogoPaginati(String criterio, int numPage, int elemPage) {
        return prodottoRepository.findByCodiceEqualsOrDescrizioneContains(criterio, criterio, PageRequest.of(numPage, elemPage));
    }
}
