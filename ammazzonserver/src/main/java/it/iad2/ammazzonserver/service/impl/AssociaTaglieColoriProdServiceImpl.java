package it.iad2.ammazzonserver.service.impl;

import it.iad2.ammazzonserver.dto.ListaProdottiColoriDto;
import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ListaColoreTaglieDto;
import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.ProdottoColore;
import it.iad2.ammazzonserver.service.AssociaTaglieColoriProdService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AssociaTaglieColoriProdServiceImpl implements AssociaTaglieColoriProdService{

    //TODO: iniettare i repository opportuni e implementare i metodi
    //@Autowired
    
    @Override
    public ListaProdottiDto cercaProdottiPerCodiceDescrizione(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaProdottiColoriDto mostraColoriAssociatiAProdotto(Prodotto prodotto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaColoreTaglieDto mostraTaglieAssociateAProdottoColore(ProdottoColore prodColore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaColoreTaglieDto mostraTaglieNonAssociateAProdottoColore(ProdottoColore prodColore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
