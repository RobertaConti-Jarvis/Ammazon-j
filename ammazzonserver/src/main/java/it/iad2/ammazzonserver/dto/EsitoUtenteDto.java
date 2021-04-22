package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.UtenteRegistrato;

public class EsitoUtenteDto {
    
    private boolean esito;
    private UtenteRegistrato utenteReg;

    public EsitoUtenteDto() {
    }

    public EsitoUtenteDto(boolean esito, UtenteRegistrato utenteReg) {
        this.esito = esito;
        this.utenteReg = utenteReg;
    }

    public boolean isEsitoLogin() {
        return esito;
    }

    public void setEsitoLogin(boolean esito) {
        this.esito = esito;
    }

    public UtenteRegistrato getUtenteReg() {
        return utenteReg;
    }

    public void setUtenteReg(UtenteRegistrato utenteReg) {
        this.utenteReg = utenteReg;
    }

    @Override
    public String toString() {
        return "EsitoLoginDto{" + "esito=" + esito + ", utenteReg=" + utenteReg + '}';
    }
    
    
    
}
