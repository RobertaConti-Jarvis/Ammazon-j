package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.ProdottoColore;

public class ProdottoColoreDto {
    private ProdottoColore prodottoColore;

    public ProdottoColoreDto() {
    }

    public ProdottoColoreDto(ProdottoColore prodottoColore) {
        this.prodottoColore = prodottoColore;
    }

    public ProdottoColore getProdottoColore() {
        return prodottoColore;
    }

    public void setProdottoColore(ProdottoColore prodottoColore) {
        this.prodottoColore = prodottoColore;
    }
}
