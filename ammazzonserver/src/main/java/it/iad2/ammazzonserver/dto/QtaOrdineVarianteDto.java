package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.QtaOrdineVariante;

public class QtaOrdineVarianteDto {
private QtaOrdineVariante qtaOrdineVariante;    

    public QtaOrdineVarianteDto() {
    }

    public QtaOrdineVarianteDto(QtaOrdineVariante qtaOrdineVariante) {
        this.qtaOrdineVariante = qtaOrdineVariante;
    }

    public QtaOrdineVariante getQtaOrdineVariante() {
        return qtaOrdineVariante;
    }

    public void setQtaOrdineVariante(QtaOrdineVariante qtaOrdineVariante) {
        this.qtaOrdineVariante = qtaOrdineVariante;
    }

    @Override
    public String toString() {
        return "QtaOrdineVarianteDto{" + "qtaOrdineVariante=" + qtaOrdineVariante + '}';
    }


}
