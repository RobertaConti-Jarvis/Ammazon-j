package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ListaColoreTaglieDto;
import it.iad2.ammazzonserver.dto.ListaProdottiColoriDto;
import it.iad2.ammazzonserver.dto.ListaVarianteTaglieDto;
import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.ProdottoColore;
import it.iad2.ammazzonserver.repository.ColoreTagliaRepository;
import it.iad2.ammazzonserver.repository.ProdottoColoreRepository;
import it.iad2.ammazzonserver.repository.ProdottoRepository;
import it.iad2.ammazzonserver.repository.VarianteTagliaRepository;
import it.iad2.ammazzonserver.service.AssociaTaglieColoriProdService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AssociaTaglieColoriProdServiceImpl implements AssociaTaglieColoriProdService {

    @Autowired
    ProdottoRepository prodottoRepository;
    
    @Autowired
    ColoreTagliaRepository coloreTagliaRepository;
    
    @Autowired
    ProdottoColoreRepository prodottoColoreRepository;
    
    @Autowired 
    VarianteTagliaRepository varianteTagliaRepository;
    
    @Override
    public ListaProdottiDto cercaProdottiPerCodiceDescrizione(String criterio) {
        return new ListaProdottiDto(
                prodottoRepository.cercaEqualsCodiceLikeDescrizione(criterio, criterio));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaColoreTaglieDto associaColoreTaglia(ColoreTaglia taglia, ProdottoColore prodColore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaColoreTaglieDto associaTuttiColoriTaglie(ProdottoColore prodColore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaColoreTaglieDto disassociaTuttiColoriTaglie(ProdottoColore prodColore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
