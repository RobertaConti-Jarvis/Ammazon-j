package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.QtaOrdineVariante;
import java.util.ArrayList;
import java.util.List;

public class ListaQtaOrdineVarianteDto {
private List<QtaOrdineVariante> listaQtaOrdineVariante; 

    public ListaQtaOrdineVarianteDto() {
    }

    public ListaQtaOrdineVarianteDto(List<QtaOrdineVariante> listaQtaOrdineVariante) {
        this.listaQtaOrdineVariante = listaQtaOrdineVariante;
    }

    public List<QtaOrdineVariante> getListaQtaOrdineVariante() {
        if(listaQtaOrdineVariante == null){
            listaQtaOrdineVariante = new ArrayList<>();
        }
        return listaQtaOrdineVariante;
    }

    public void setListaQtaOrdineVariante(List<QtaOrdineVariante> listaQtaOrdineVariante) {
        this.listaQtaOrdineVariante = listaQtaOrdineVariante;
    }

    @Override
    public String toString() {
        return "ListaQtaOrdineVarianteDto{" + "listaQtaOrdineVariante=" + listaQtaOrdineVariante + '}';
    }


}
