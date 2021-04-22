package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.Ordine;

public class OrdineDto {
    
    private Ordine ordine;

    public OrdineDto() {
    }

    public OrdineDto(Ordine ordine) {
        this.ordine = ordine;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }
    
}
