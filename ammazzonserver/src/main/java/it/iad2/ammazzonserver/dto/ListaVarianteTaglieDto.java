package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.VarianteTaglia;
import java.util.List;

public class ListaVarianteTaglieDto {

    List<VarianteTaglia> listaVarianteTaglie;

    public ListaVarianteTaglieDto() {
    }

    public ListaVarianteTaglieDto(List<VarianteTaglia> listaVarianteTaglie) {
        this.listaVarianteTaglie = listaVarianteTaglie;
    }

    public List<VarianteTaglia> getListaVarianteTaglie() {
        return listaVarianteTaglie;
    }

    public void setListaVarianteTaglie(List<VarianteTaglia> listaVarianteTaglie) {
        this.listaVarianteTaglie = listaVarianteTaglie;
    }

}
