package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.Ordine;

public class datiOrdinePageDto {
    int numPag;
    int elemPag;
    Ordine ordine;

    public datiOrdinePageDto() {
    }

    public datiOrdinePageDto(int numPag, int elemPag, Ordine ordine) {
        this.numPag = numPag;
        this.elemPag = elemPag;
        this.ordine = ordine;
    }

    public int getNumPag() {
        return numPag;
    }

    public int getElemPag() {
        return elemPag;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public void setElemPag(int elemPag) {
        this.elemPag = elemPag;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    @Override
    public String toString() {
        return "datiOrdinePageDto{" +
                "numPag=" + numPag +
                ", elemPag=" + elemPag +
                ", ordine=" + ordine +
                '}';
    }
}
