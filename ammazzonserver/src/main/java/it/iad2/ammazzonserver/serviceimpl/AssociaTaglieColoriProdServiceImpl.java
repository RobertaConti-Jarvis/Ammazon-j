package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ListaColoreTaglieDto;
import it.iad2.ammazzonserver.dto.ListaProdottiColoriDto;
import it.iad2.ammazzonserver.dto.ListaVarianteTaglieDto;
import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.ProdottoColore;
import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import it.iad2.ammazzonserver.model.VarianteColore;
import it.iad2.ammazzonserver.model.VarianteTaglia;
import it.iad2.ammazzonserver.repository.ColoreTagliaRepository;
import it.iad2.ammazzonserver.repository.ProdottoColoreRepository;
import it.iad2.ammazzonserver.repository.ProdottoRepository;
import it.iad2.ammazzonserver.repository.QtaOrdineVarianteRepository;
import it.iad2.ammazzonserver.repository.VarianteTagliaRepository;
import it.iad2.ammazzonserver.service.AssociaTaglieColoriProdService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AssociaTaglieColoriProdServiceImpl implements AssociaTaglieColoriProdService {

    private final Logger logger = LoggerFactory.getLogger(AssociaTaglieColoriProdServiceImpl.class);

    @Autowired
    ProdottoRepository prodottoRepository;

    @Autowired
    ColoreTagliaRepository coloreTagliaRepository;

    @Autowired
    ProdottoColoreRepository prodottoColoreRepository;

    @Autowired
    VarianteTagliaRepository varianteTagliaRepository;

    @Autowired
    QtaOrdineVarianteRepository qtaOrdineVarianteRepository;

    @Override
    public ListaProdottiDto cercaProdottiPerCodiceDescrizione(String criterio) {
        return new ListaProdottiDto(
                prodottoRepository.cercaPerCriterioDescrizione(criterio, criterio));
    }

    @Override
    public ListaProdottiColoriDto mostraColoriAssociatiAProdotto(Prodotto prodotto) {
        return new ListaProdottiColoriDto(
                prodottoColoreRepository.trovaListaVarianteColoreProdotto(prodotto.getId()));
    }

    @Override
    public ListaColoreTaglieDto mostraTaglieAssociateAProdottoColore(ProdottoColore prodColore) {
        return new ListaColoreTaglieDto(
                coloreTagliaRepository.trovaListaVarianteColoreProdotto(prodColore.getId()));
    }

    @Override
    public ListaVarianteTaglieDto mostraTaglieNonAssociateAProdottoColore(ProdottoColore prodColore) {
        return new ListaVarianteTaglieDto(varianteTagliaRepository.trovaTaglieNonAssociate(prodColore));
    }

    @Override
    public ListaColoreTaglieDto rimuoviColoreTaglia(ColoreTaglia taglia, ProdottoColore prodColore) {
        logger.debug("Siamo in rimuoviColoreTaglia");
        taglia = coloreTagliaRepository.findById(taglia.getId()).get();
        List<QtaOrdineVariante> qov = taglia.getListaQtaOrdineVariante();
        logger.debug("Prima della sout");
//        System.out.println("RIMUOVI COLORE TAGLIA - QtaOrdine: " + qov);
        qtaOrdineVarianteRepository.deleteInBatch(qov);
        coloreTagliaRepository.delete(taglia);
        logger.debug("Stiamo uscendo da rimuoviColoreTaglia");
        return mostraTaglieAssociateAProdottoColore(prodColore);
    }

    @Override
    public ListaColoreTaglieDto associaColoreTaglia(VarianteTaglia taglia, ProdottoColore prodColore) {
        taglia = varianteTagliaRepository.findById(taglia.getId()).get();
        ColoreTaglia ct = new ColoreTaglia();
        ct.setVarianteTaglia(taglia);
        ct.setProdottoColore(prodColore);
        ct = coloreTagliaRepository.save(ct);
        prodColore.getListaColoreTaglia().add(ct);
        prodottoColoreRepository.save(prodColore);
        return mostraTaglieAssociateAProdottoColore(prodColore);
    }

    @Override
    public ListaColoreTaglieDto associaTuttiColoriTaglie(ProdottoColore prodColore) {
        logger.debug("Siamo nell'associa tutti");
        List<VarianteTaglia> vt = mostraTaglieNonAssociateAProdottoColore(prodColore).getListaVarianteTaglie();
        prodColore = prodottoColoreRepository.findById(prodColore.getId()).get();
        List<ColoreTaglia> listaCt = new ArrayList<>();
        for (VarianteTaglia varianteTaglia : vt) {
            ColoreTaglia ct = new ColoreTaglia();
            logger.debug("variante taglia " + varianteTaglia.getCodice());
            ct.setVarianteTaglia(varianteTaglia);
            ct.setProdottoColore(prodColore);
            coloreTagliaRepository.save(ct);
            listaCt.add(ct);
        }
        prodColore.getListaColoreTaglia().addAll(listaCt);
        prodottoColoreRepository.save(prodColore);
        return mostraTaglieAssociateAProdottoColore(prodColore);
    }

    @Override
    public ListaColoreTaglieDto disassociaTuttiColoriTaglie(ProdottoColore prodColore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
