
package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.VarianteColore;
import org.springframework.data.domain.Page;


public class PageColoriDto {
    Page<VarianteColore>listaElemPage;

    public PageColoriDto() {
    }

    public PageColoriDto(Page<VarianteColore> listaElemPage) {
        this.listaElemPage = listaElemPage;
    }

    public Page<VarianteColore> getListaElemPage() {
        return listaElemPage;
    }

    public void setListaElemPage(Page<VarianteColore> listaElemPage) {
        this.listaElemPage = listaElemPage;
    }

    @Override
    public String toString() {
        return "PageColoriDto{" + "listaElemPage=" + listaElemPage + '}';
    }
    
    
}
