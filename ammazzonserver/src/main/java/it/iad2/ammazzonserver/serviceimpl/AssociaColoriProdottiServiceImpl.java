package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ListeColoriProdottoDto;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.VarianteColore;
import it.iad2.ammazzonserver.repository.ProdottoColoreRepository;
import it.iad2.ammazzonserver.repository.ProdottoRepository;
import it.iad2.ammazzonserver.service.AssociaColoriProdottiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociaColoriProdottiServiceImpl implements AssociaColoriProdottiService {

    @Autowired
    ProdottoRepository prodottoRepository;
    @Autowired
    ProdottoColoreRepository prodottoColoreRepository;

    @Override
    public ListaProdottiDto cercaProdotto(String criterio) {
        return new ListaProdottiDto(prodottoRepository.cercaPerCriterio(criterio, "%" + criterio + "%"));
    }

    @Override
    public ListeColoriProdottoDto seleziona(Prodotto p) {
        List<VarianteColore> listaColoriAssociati = prodottoColoreRepository.selezionaColoriAssociatiProdotto(p.getId());

        List<VarianteColore> listaColoriNonAssociati = prodottoColoreRepository.selezionaColoriAssociatiProdotto(p.getId());
        return new ListeColoriProdottoDto(listaColoriAssociati, listaColoriNonAssociati);
    }

}
