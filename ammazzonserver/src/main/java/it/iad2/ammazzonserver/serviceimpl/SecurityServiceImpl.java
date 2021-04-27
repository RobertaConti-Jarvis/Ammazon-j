package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.EsitoDto;
import it.iad2.ammazzonserver.dto.EsitoUtenteDto;
import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.model.UtenteAnonimo;
import it.iad2.ammazzonserver.model.UtenteRegistrato;
import it.iad2.ammazzonserver.repository.UtenteAnonimoRepository;
import it.iad2.ammazzonserver.repository.UtenteRegistratoRepository;
import it.iad2.ammazzonserver.service.SecurityService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    UtenteRegistratoRepository utenteRegistratoRepository;
    @Autowired
    UtenteAnonimoRepository utenteAnonimoRepository;

    @Override
    public boolean checkUsername(String username) {
        UtenteRegistrato u = utenteRegistratoRepository.findUsername(username);
        if (u != null) {
            return false;
        }
        return true;
    }

    @Override
    public EsitoUtenteDto checkLogin(UtenteRegistrato utenteRegistrato, String token) {
        UtenteRegistrato uR = utenteRegistratoRepository.findUsernameAndPassword(utenteRegistrato.getUsername(), utenteRegistrato.getPassword());
        if (uR != null) {
            //codice aggiunto per assegnare il carrello dell'Utente Anonimo al nuovo Utente Registrato
            UtenteAnonimo uA = utenteAnonimoRepository.cercaUtenteAnonimoPerToken(token);
            if (uA != null) {
                List<Ordine> ordini = uR.getListaOrdine();
                ordini.add(uA.getOrdine());
                uR.setListaOrdine(ordini);
                utenteAnonimoRepository.delete(uA);     //cancellazione utente anonimo
            }
            //controllo se il tokenRandom creato è già stato utilizzato
            String tokenRandom;
            UtenteRegistrato uRToken;
            do {
                tokenRandom = UUID.randomUUID().toString().toUpperCase();
                uRToken = utenteRegistratoRepository.cercaUtenteRegistratoPerToken(tokenRandom);
            } while (uRToken != null);
            //settaggi token
            uR.setTokenAnonimo(null);
            uR.setTokenRegistrato(tokenRandom);
            //aggiorno repository
            utenteRegistratoRepository.save(uR);
            return new EsitoUtenteDto(true, uR, uR.getTokenRegistrato());
        }
        System.out.println("credenziali non trovate!");
        return new EsitoUtenteDto(false, utenteRegistrato, token);
    }

    @Override
    public EsitoUtenteDto registrazione(UtenteRegistrato utenteRegistrato, String token) {
        UtenteRegistrato uR = utenteRegistratoRepository.findEmailOrTokenOrUsername(utenteRegistrato.getEmail(), token, utenteRegistrato.getUsername());
        if (uR == null) {
            uR = new UtenteRegistrato(utenteRegistrato.getUsername(), utenteRegistrato.getPassword(), utenteRegistrato.getEmail());
            utenteRegistratoRepository.save(uR);
            return new EsitoUtenteDto(true, uR, token);
        }
        System.out.println("Email utilizzata o utente loggato!");
        return new EsitoUtenteDto(false, utenteRegistrato, token);
    }

    @Override
    public EsitoUtenteDto checkTokenReg(String token) {
        UtenteRegistrato uR = utenteRegistratoRepository.cercaUtenteRegistratoPerToken(token);
        if (uR != null) {
            return new EsitoUtenteDto(true, uR, token);
        }
        return new EsitoUtenteDto(false, null, token);
    }

    @Override
    public EsitoDto logout(String token) {
        UtenteRegistrato uR = utenteRegistratoRepository.cercaUtenteRegistratoPerToken(token);
        if (uR != null) {
            uR.setTokenRegistrato(null);
            utenteRegistratoRepository.save(uR);
            return new EsitoDto(true, token);
        }
        return new EsitoDto(false, token);
    }

}
