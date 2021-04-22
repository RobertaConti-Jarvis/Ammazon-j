package it.iad2.ammazzonserver.dto;

public class EsitoDto {
    private boolean esito;

    public EsitoDto(boolean esito) {
        this.esito = esito;
    }

    public boolean isEsito() {
        return esito;
    }

    public void setEsito(boolean esito) {
        this.esito = esito;
    }

    @Override
    public String toString() {
        return "EsitoDto{" + "esito=" + esito + '}';
    }
    
    
}
