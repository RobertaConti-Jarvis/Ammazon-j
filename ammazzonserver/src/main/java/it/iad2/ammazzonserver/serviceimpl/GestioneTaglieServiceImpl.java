package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import it.iad2.ammazzonserver.model.VarianteTaglia;
import it.iad2.ammazzonserver.repository.ColoreTagliaRepository;
import it.iad2.ammazzonserver.repository.ProdottoColoreRepository;
import it.iad2.ammazzonserver.repository.QtaOrdineVarianteRepository;
import it.iad2.ammazzonserver.repository.VarianteTagliaRepository;
import it.iad2.ammazzonserver.service.GestioneTaglieService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GestioneTaglieServiceImpl implements GestioneTaglieService {

    final Logger logger = LoggerFactory.getLogger(GestioneTaglieServiceImpl.class);

    @Autowired
    VarianteTagliaRepository varianteTagliaRepository;

    @Autowired
    ColoreTagliaRepository coloreTagliaRepository;

    @Autowired
    ProdottoColoreRepository prodottoColoreRepository;

    @Autowired
    QtaOrdineVarianteRepository qtaOrdineVarianteRepository;

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

    @Transactional
    @Override
    public List<VarianteTaglia> rimuovi(VarianteTaglia taglia) {
        logger.debug("Entrati in rimuovi");
        taglia = varianteTagliaRepository.findById(taglia.getId()).get();
        if (taglia == null) {
            System.out.println("taglia not found!!!!");
            return new ArrayList<>();
        }
        List<ColoreTaglia> coloriTaglia = taglia.getListaColoreTaglia();

        coloriTaglia.forEach(ct -> {
            List<QtaOrdineVariante> qov = ct.getListaQtaOrdineVariante();
            qtaOrdineVarianteRepository.deleteInBatch(qov);
        });
        coloreTagliaRepository.deleteInBatch(coloriTaglia);

        varianteTagliaRepository.delete(taglia);
        return aggiorna();
    }

    @Override
    public List<VarianteTaglia> aggiorna() {
        return varianteTagliaRepository.findAll();
    }

}
