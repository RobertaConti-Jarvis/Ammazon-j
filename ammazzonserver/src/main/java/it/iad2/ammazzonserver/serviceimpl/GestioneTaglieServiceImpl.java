package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.ProdottoColore;
import it.iad2.ammazzonserver.model.VarianteTaglia;
import it.iad2.ammazzonserver.repository.ColoreTagliaRepository;
import it.iad2.ammazzonserver.repository.ProdottoColoreRepository;
import it.iad2.ammazzonserver.repository.VarianteTagliaRepository;
import it.iad2.ammazzonserver.service.GestioneTaglieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestioneTaglieServiceImpl implements GestioneTaglieService {

    @Autowired
    VarianteTagliaRepository varianteTagliaRepository;

    @Autowired
    ColoreTagliaRepository coloreTagliaRepository;

    @Autowired
    ProdottoColoreRepository prodottoColoreRepository;

    @Override
    public List<VarianteTaglia> ricerca(String criterio) {
        return varianteTagliaRepository.findByCodiceContains(criterio);
    }

    @Override
    public List<VarianteTaglia> modifica(VarianteTaglia taglia) {
        varianteTagliaRepository.save(taglia);
        return aggiorna();
    }

    @Override
    public List<VarianteTaglia> aggiungi(VarianteTaglia taglia) {
        varianteTagliaRepository.save(taglia);
        return aggiorna();
    }

    @Override
    public List<VarianteTaglia> rimuovi(VarianteTaglia taglia) {
        List<ColoreTaglia> coloriTaglia = taglia.getListaColoreTaglia();
//      prendi prodotto colore
        coloriTaglia.forEach(r -> {
            ProdottoColore pc = r.getProdottoColore();
            pc.getListaColoreTaglia().removeIf((t) -> t.getId().equals(r.getId()));
            prodottoColoreRepository.save(pc);
        });
//      rimuovi taglia da prodotto colore

        coloriTaglia.forEach(r -> {
            VarianteTaglia vt = r.getVarianteTaglia();
            vt.getListaColoreTaglia().removeIf((t) -> t.getId().equals(r.getId()));
            varianteTagliaRepository.save(vt);
            coloreTagliaRepository.delete(r);
        });
        varianteTagliaRepository.delete(taglia);
        return aggiorna();
    }

    @Override
    public List<VarianteTaglia> aggiorna() {
        return varianteTagliaRepository.findAll();
    }

}
