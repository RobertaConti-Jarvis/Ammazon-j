package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.ColoreTaglia;
import java.util.ArrayList;
import java.util.List;

public class ListaTaglieDto {

    private List<ColoreTaglia> listaTaglie;

    public ListaTaglieDto(List<ColoreTaglia> listaTaglie) {
        this.listaTaglie = listaTaglie;
    }

    public ListaTaglieDto() {
    }

    public List<ColoreTaglia> getListaTaglie() {
        if (listaTaglie == null){
            listaTaglie = new ArrayList<>();
        }
        return listaTaglie;
    }

    public void setListaTaglie(List<ColoreTaglia> listaTaglie) {
        this.listaTaglie = listaTaglie;
    }

}
