package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.dto.EsitoDto;
import it.iad2.ammazzonserver.dto.EsitoUtenteDto;
import it.iad2.ammazzonserver.model.UtenteRegistrato;

public interface SecurityService {

    EsitoUtenteDto checkLogin(UtenteRegistrato utenteRegistrato, String token);

    boolean checkUsername(String username);

    EsitoUtenteDto registrazione(UtenteRegistrato utenteRegistrato, String token);

    EsitoUtenteDto checkTokenReg(String token);

    EsitoDto logout(String token);

    EsitoUtenteDto aggiornaDati(UtenteRegistrato utenteRegistrato, String token);

    EsitoUtenteDto eliminaAccount(UtenteRegistrato utenteRegistrato, String token);

}
