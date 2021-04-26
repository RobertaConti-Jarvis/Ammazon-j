package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.UtenteRegistrato;

public class EsitoUtenteDto extends BaseRequestDto{
    
    private boolean esito;
    private UtenteRegistrato utenteReg;

    public EsitoUtenteDto() {
    }

    public EsitoUtenteDto(boolean esito, UtenteRegistrato utenteReg) {
        this.esito = esito;
        this.utenteReg = utenteReg;
    }

    public EsitoUtenteDto(boolean esito, UtenteRegistrato utenteReg, String sessionToken) {
        super(sessionToken);
        this.esito = esito;
        this.utenteReg = utenteReg;
    }

    public boolean isEsito() {
        return esito;
    }

    public void setEsito(boolean esito) {
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
