package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.Ordine;

import java.util.List;

public class ListaOrdiniDto {
    private List<Ordine> listaOrdini;

    public ListaOrdiniDto() {
    }

    public ListaOrdiniDto(List<Ordine> listaOrdini) {
        this.listaOrdini = listaOrdini;
    }

    public List<Ordine> getListaOrdini() {
        return listaOrdini;
    }

    public void setListaOrdini(List<Ordine> listaOrdini) {
        this.listaOrdini = listaOrdini;
    }

    @Override
    public String toString() {
        return "ListaOrdiniDto{" +
                "listaOrdini=" + listaOrdini +
                '}';
    }
}
