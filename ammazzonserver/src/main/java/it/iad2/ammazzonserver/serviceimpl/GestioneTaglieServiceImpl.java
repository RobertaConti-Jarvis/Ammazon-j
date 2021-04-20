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
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GestioneTaglieServiceImpl implements GestioneTaglieService {
    
    private static final Logger logger = Logger.getLogger(GestioneTaglieServiceImpl.class.getName());
    
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
        taglia = varianteTagliaRepository.findById(taglia.getId()).get();
        if (taglia == null) {
            System.out.println("taglia not found!!!!");
            return new ArrayList<>();
        }
        List<ColoreTaglia> coloriTaglia = taglia.getListaColoreTaglia();

        //      prendi prodotto colore
//        coloriTaglia.forEach(r -> {
//            System.out.println("At foreach beginning");
//            ProdottoColore pc = r.getProdottoColore();
//            pc.getListaColoreTaglia().removeIf((t) -> t.getId().equals(r.getId()));
//            prodottoColoreRepository.save(pc);
//            System.out.println("prodottoColoreRepository.save(pc)");
////            r.setProdottoColore(null);
//            VarianteTaglia vt = r.getVarianteTaglia();
//            vt.getListaColoreTaglia().removeIf((t) -> t.getId().equals(r.getId()));
//            varianteTagliaRepository.save(vt);
//            System.out.println(" varianteTagliaRepository.save(vt);");
////            r.setVarianteTaglia(null);
//            System.out.println(" coloreTagliaRepository.save(r)");
//            System.out.println("  coloreTagliaRepository.delete(r)");
//            System.out.println("At foreach end");
//        });
        coloriTaglia.forEach(ct -> {
            List<QtaOrdineVariante> qov = ct.getListaQtaOrdineVariante();
            qtaOrdineVarianteRepository.deleteInBatch(qov);
        });
        coloreTagliaRepository.deleteInBatch(coloriTaglia);

        //      rimuovi taglia da prodotto colore
//        coloriTaglia.forEach(r -> {
//            VarianteTaglia vt = r.getVarianteTaglia();
//            vt.getListaColoreTaglia().removeIf((t) -> t.getId().equals(r.getId()));
//            varianteTagliaRepository.save(vt);
//            coloreTagliaRepository.delete(r);
//        });
        varianteTagliaRepository.delete(taglia);
        return aggiorna();
    }
    
    @Override
    public List<VarianteTaglia> aggiorna() {
        return varianteTagliaRepository.findAll();
    }
    
}
