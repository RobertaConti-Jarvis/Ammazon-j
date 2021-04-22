package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.EsitoUtenteDto;
import it.iad2.ammazzonserver.model.UtenteAnonimo;
import it.iad2.ammazzonserver.model.UtenteRegistrato;
import it.iad2.ammazzonserver.repository.UtenteAnonimoRepository;
import it.iad2.ammazzonserver.repository.UtenteRegistratoRepository;
import it.iad2.ammazzonserver.service.SecurityService;
import java.time.LocalDateTime;
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
        } else {
            return true;
        }
    }

    @Override
    public EsitoUtenteDto checkLogin(UtenteRegistrato utenteRegistrato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EsitoUtenteDto registrazione(UtenteRegistrato utenteRegistrato) {
        /*UtenteAnonimo uA = (UtenteAnonimo) utenteRegistrato;
        UtenteAnonimo uATrovato = utenteAnonimoRepository.findId(uA.getId());
        String tkA = null;
        if(uATrovato !=null){
           tkA = uATrovato.getTokenAnonimo(); 
        }
        if (tkA == null) {
            UtenteRegistrato uR = utenteRegistratoRepository.findEmail(utenteRegistrato.getEmail());
            if (uR != null) {
                return new EsitoUtenteDto(false, utenteRegistrato);
            } else {
                utenteRegistrato.setTokenRegistrato(utenteRegistrato.getId().toString() + LocalDateTime.now());
                utenteRegistratoRepository.save(utenteRegistrato);
                return new EsitoUtenteDto(true, utenteRegistrato);
            }
        }
        else{
            utenteRegistrato.setTokenRegistrato(utenteRegistrato.getId().toString() + LocalDateTime.now());
            
        }*/
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
