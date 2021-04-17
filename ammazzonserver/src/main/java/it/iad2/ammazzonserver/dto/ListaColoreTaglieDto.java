package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.ColoreTaglia;
import java.util.ArrayList;
import java.util.List;

public class ListaColoreTaglieDto {

    private List<ColoreTaglia> listaColoreTaglie;

    public ListaColoreTaglieDto(List<ColoreTaglia> listaColoreTaglie) {
        this.listaColoreTaglie = listaColoreTaglie;
    }

    public ListaColoreTaglieDto() {
    }

    public List<ColoreTaglia> getListaColoreTaglie() {
        if (listaColoreTaglie == null){
            listaColoreTaglie = new ArrayList<>();
        }
        return listaColoreTaglie;
    }

    public void setListaColoreTaglie(List<ColoreTaglia> listaColoreTaglie) {
        this.listaColoreTaglie = listaColoreTaglie;
    }

}
