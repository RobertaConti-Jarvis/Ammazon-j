package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.VarianteColore;
import java.util.ArrayList;
import java.util.List;

public class ListaVarianteColoreDto {
    List<VarianteColore> listaVarianteColore;

    public ListaVarianteColoreDto() {
    }

    public ListaVarianteColoreDto(List<VarianteColore> listaVarianteColore) {
        this.listaVarianteColore = listaVarianteColore;
    }

    public List<VarianteColore> getListaVarianteColore() {
        if(listaVarianteColore == null){
            listaVarianteColore = new ArrayList<>();
        }
        return listaVarianteColore;
    }

    public void setListaVarianteColore(List<VarianteColore> listaVarianteColore) {
        this.listaVarianteColore = listaVarianteColore;
    }
    
}
