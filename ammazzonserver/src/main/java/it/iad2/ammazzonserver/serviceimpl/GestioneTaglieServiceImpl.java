package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.VarianteTaglia;
import it.iad2.ammazzonserver.repository.VarianteTagliaRepository;
import it.iad2.ammazzonserver.service.GestioneTaglieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestioneTaglieServiceImpl implements GestioneTaglieService {

    @Autowired
    VarianteTagliaRepository varianteTagliaRepository;

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
        varianteTagliaRepository.delete(taglia);
        return aggiorna();
    }

    @Override
    public List<VarianteTaglia> aggiorna() {
        return varianteTagliaRepository.findAll();
    }

}
