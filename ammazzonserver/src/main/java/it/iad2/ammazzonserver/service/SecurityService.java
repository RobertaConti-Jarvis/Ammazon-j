package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.dto.EsitoUtenteDto;
import it.iad2.ammazzonserver.model.UtenteRegistrato;

public interface SecurityService {

    EsitoUtenteDto checkLogin(UtenteRegistrato utenteRegistrato);

    boolean checkUsername(String username);
    
    EsitoUtenteDto registrazione(UtenteRegistrato utenteRegistrato);

}