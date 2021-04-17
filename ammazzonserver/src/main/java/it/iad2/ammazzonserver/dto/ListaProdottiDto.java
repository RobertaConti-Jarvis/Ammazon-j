package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.Prodotto;
import java.util.ArrayList;
import java.util.List;

public class ListaProdottiDto {
    private List<Prodotto> listaProdotti;

    public ListaProdottiDto() {
    }

    public ListaProdottiDto(List<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public List<Prodotto> getListaProdotti() {
        if (listaProdotti == null){
            listaProdotti = new ArrayList<>();
        }
        return listaProdotti;
    }

    public void setListaProdotti(List<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }
    
}
