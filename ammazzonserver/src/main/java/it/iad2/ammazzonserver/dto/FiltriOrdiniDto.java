package it.iad2.ammazzonserver.dto;

public class FiltriOrdiniDto {
    private String tipo;
    private String ordine;
    private String stato;

    public FiltriOrdiniDto() {
    }

    public FiltriOrdiniDto(String tipo, String ordine, String stato) {
        this.tipo = tipo;
        this.ordine = ordine;
        this.stato = stato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrdine() {
        return ordine;
    }

    public void setOrdine(String ordine) {
        this.ordine = ordine;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "FiltriOrdiniDto{" +
                "tipo='" + tipo + '\'' +
                ", ordine='" + ordine + '\'' +
                ", stato='" + stato + '\'' +
                '}';
    }
}
