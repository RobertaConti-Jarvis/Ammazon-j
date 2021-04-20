package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.VarianteColore;
import java.util.ArrayList;
import java.util.List;

public class ListeColoriProdottoDto {

    List<VarianteColore> coloriAssociati = new ArrayList<>();
    List<VarianteColore> coloriNonAssociati = new ArrayList<>();

    public ListeColoriProdottoDto() {

    }

    public ListeColoriProdottoDto(List<VarianteColore> coloriAssociati, List<VarianteColore> coloriNonAssociati) {
        this.coloriAssociati = coloriAssociati;
        this.coloriNonAssociati = coloriNonAssociati;

    }

    public List<VarianteColore> getColoriAssociati() {
        return coloriAssociati;
    }

    public void setColoriAssociati(List<VarianteColore> coloriAssociati) {
        this.coloriAssociati = coloriAssociati;
    }

    public List<VarianteColore> getColoriNonAssociati() {
        return coloriNonAssociati;
    }

    public void setColoriNonAssociati(List<VarianteColore> coloriNonAssociati) {
        this.coloriNonAssociati = coloriNonAssociati;
    }

    @Override
    public String toString() {
        return "ListeColoriProdottoDto{" + "coloriAssociati=" + coloriAssociati + ", coloriNonAssociati=" + coloriNonAssociati + '}';
    }

}
