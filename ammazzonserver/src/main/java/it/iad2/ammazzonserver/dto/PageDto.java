package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.Prodotto;
import org.springframework.data.domain.Page;


public class PageDto {
    
    Page<Prodotto> listaElemPag;

    public PageDto() {
    }

    public PageDto(Page<Prodotto> listaElemPag) {
        this.listaElemPag = listaElemPag;
    }

    public Page<Prodotto> getListaElemPag() {
        return listaElemPag;
    }

    public void setListaElemPag(Page<Prodotto> listaElemPag) {
        this.listaElemPag = listaElemPag;
    }

    @Override
    public String toString() {
        return "PageDto{" + "listaElemPag=" + listaElemPag + '}';
    }

    
}
