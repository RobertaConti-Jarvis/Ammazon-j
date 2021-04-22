package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.UtenteRegistrato;
import org.springframework.data.domain.Page;

public class PageUtenteDto {
    Page<UtenteRegistrato> listaElemPag;

    public PageUtenteDto() {
    }

    public Page<UtenteRegistrato> getListaElemPag() {
        return listaElemPag;
    }

    public void setListaElemPag(Page<UtenteRegistrato> listaElemPag) {
        this.listaElemPag = listaElemPag;
    }

    public PageUtenteDto(Page<UtenteRegistrato> listaElemPag) {
        this.listaElemPag = listaElemPag;
    }

    @Override
    public String toString() {
        return "PageUtenteDto{" +
                "listaElemPag=" + listaElemPag +
                '}';
    }
}
