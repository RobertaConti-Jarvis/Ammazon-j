package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.Ordine;

public class OrdineDto extends BaseRequestDto {

    private Ordine ordine;
    private int numElem;
    private double totale;

    public OrdineDto() {
    }

    public OrdineDto(Ordine ordine, int numElem) {
        this.ordine = ordine;
        this.numElem = numElem;
    }

    public OrdineDto(Ordine ordine, int numElem, String sessionToken) {
        super(sessionToken);
        this.ordine = ordine;
        this.numElem = numElem;
    }

    public OrdineDto(Ordine ordine, int numElem, double totale) {
        this.ordine = ordine;
        this.numElem = numElem;
        this.totale = totale;
    }

    public OrdineDto(Ordine ordine, int numElem, double totale, String sessionToken) {
        super(sessionToken);
        this.ordine = ordine;
        this.numElem = numElem;
        this.totale = totale;
    }
    

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public int getNumElem() {
        return numElem;
    }

    public void setNumElem(int numElem) {
        this.numElem = numElem;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

}
