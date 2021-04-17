package it.iad2.ammazzonserver.service.impl;

import it.iad2.ammazzonserver.dto.ListaProdottiColoriDto;
import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ListaColoreTaglieDto;
import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.ProdottoColore;
import it.iad2.ammazzonserver.service.AssociaTaglieColoriProdService;

public class AssociaTaglieColoriProdServiceImpl implements AssociaTaglieColoriProdService{

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
    public ListaColoreTaglieDto rimuoviTaglia(ColoreTaglia taglia, ProdottoColore prodColore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaColoreTaglieDto associaTaglia(ColoreTaglia taglia, ProdottoColore prodColore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaColoreTaglieDto associaTutteLeTaglie(ProdottoColore prodColore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaColoreTaglieDto disassociaTutteLeTaglie(ProdottoColore prodColore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
