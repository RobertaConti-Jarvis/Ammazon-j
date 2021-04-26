package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.EsitoUtenteDto;
import it.iad2.ammazzonserver.model.UtenteAnonimo;
import it.iad2.ammazzonserver.model.UtenteRegistrato;
import it.iad2.ammazzonserver.repository.UtenteAnonimoRepository;
import it.iad2.ammazzonserver.repository.UtenteRegistratoRepository;
import it.iad2.ammazzonserver.service.SecurityService;
import java.time.LocalDateTime;
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
        UtenteRegistrato uR = utenteRegistratoRepository.findUsernameAndPassword(utenteRegistrato.getUsername(),utenteRegistrato.getPassword());
        if (uR != null){
            String tokenRandom = UUID.randomUUID().toString().toUpperCase();
            uR.setTokenAnonimo(null);
            uR.setTokenRegistrato(tokenRandom);
            utenteRegistratoRepository.save(uR);
            return new EsitoUtenteDto(true, utenteRegistrato , token);
        }
        System.out.println("credenziali non trovate!");
        return new EsitoUtenteDto(false , utenteRegistrato, token);
    }

    @Override
    public EsitoUtenteDto registrazione(UtenteRegistrato utenteRegistrato, String token) {
        UtenteRegistrato uR = utenteRegistratoRepository.findEmailOrTokenOrUsername(utenteRegistrato.getEmail(), token, utenteRegistrato.getUsername()); 
        if (uR == null) {
            uR = new UtenteRegistrato(utenteRegistrato.getUsername(), utenteRegistrato.getPassword(), utenteRegistrato.getEmail());
            utenteRegistratoRepository.save(uR);
            return new EsitoUtenteDto(true, uR, token);

        }
        System.out.println("l'email utilizzata o utente loggato!");
        return new EsitoUtenteDto(false, utenteRegistrato, token);
    }

}
