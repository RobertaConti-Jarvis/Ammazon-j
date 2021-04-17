package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.ProdottoColore;
import java.util.ArrayList;
import java.util.List;

public class ListaProdottiColoriDto {
    private List<ProdottoColore> listaProdottiColore;

    public ListaProdottiColoriDto() {
    }

    public ListaProdottiColoriDto(List<ProdottoColore> listaProdottiColore) {
        this.listaProdottiColore = listaProdottiColore;
    }

    public List<ProdottoColore> getListaProdottiColore() {
        if (listaProdottiColore == null){
            listaProdottiColore = new ArrayList<>();
        }
        return listaProdottiColore;
    }

    public void setListaProdottiColore(List<ProdottoColore> listaProdottiColore) {
        this.listaProdottiColore = listaProdottiColore;
    }
}
