
package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.VarianteColore;
import org.springframework.data.domain.Page;


public class PageColoriDto {
    Page<VarianteColore>listaElemPag;

    public PageColoriDto() {
    }

    public PageColoriDto(Page<VarianteColore> listaElemPag) {
        this.listaElemPag = listaElemPag;
    }

    public Page<VarianteColore> getListaElemPag() {
        return listaElemPag;
    }

    public void setListaElemPag(Page<VarianteColore> listaElemPag) {
        this.listaElemPag = listaElemPag;
    }

    @Override
    public String toString() {
        return "PageColoriDto{" + "listaElemPage=" + listaElemPag + '}';
    }
    
    
}
