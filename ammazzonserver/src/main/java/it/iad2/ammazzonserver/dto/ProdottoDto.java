package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.Prodotto;

public class ProdottoDto {
    private Prodotto prodotto;

    public ProdottoDto() {
    }

    public ProdottoDto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }
    
}
