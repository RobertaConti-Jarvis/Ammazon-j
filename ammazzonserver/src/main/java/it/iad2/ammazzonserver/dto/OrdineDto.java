package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.Ordine;

public class OrdineDto extends BaseRequestDto {

    private Ordine ordine;
    private int numElem;

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

}
