
package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.ListaVarianteColoreDto;
import it.iad2.ammazzonserver.model.VarianteColore;
import it.iad2.ammazzonserver.repository.VarianteColoreRepository;
import it.iad2.ammazzonserver.service.GestisciColoriService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GestisciColoriServiceImpl implements GestisciColoriService {

    @Autowired
    VarianteColoreRepository varianteColoreRepository;

    @Override
    public ListaVarianteColoreDto cercaPerCodice(String criterio) {
        List<VarianteColore> lista = new ArrayList<>();
        if (criterio == null) {
            lista = varianteColoreRepository.findAll();
        } else {
            lista = varianteColoreRepository.cercaColore(criterio, "%"+criterio+"%");
        }
        return new ListaVarianteColoreDto(lista);
    }

    @Override
    public ListaVarianteColoreDto rimuoviAction(VarianteColore varianteColore) {
        varianteColoreRepository.delete(varianteColore);
        return aggiorna();
    }

    @Override
    public ListaVarianteColoreDto aggiungiAction(VarianteColore varianteColore) {
        varianteColoreRepository.save(varianteColore);
        return aggiorna();
    }

    @Override
    public ListaVarianteColoreDto modificaAction(VarianteColore varianteColore) {
        varianteColoreRepository.save(varianteColore);
        return aggiorna();
    }

    @Override
    public ListaVarianteColoreDto aggiorna() {
        return new ListaVarianteColoreDto(varianteColoreRepository.findAll());

    }

    @Override
    public Page<VarianteColore> elementiPaginati(int numPage, int elemPage) {
        return varianteColoreRepository.trovaTuttiPaginati(PageRequest.of(numPage, elemPage));
    }

}
