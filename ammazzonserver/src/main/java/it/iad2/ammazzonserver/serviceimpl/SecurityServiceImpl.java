package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.EsitoUtenteDto;
import it.iad2.ammazzonserver.model.UtenteRegistrato;
import it.iad2.ammazzonserver.repository.UtenteRegistratoRepository;
import it.iad2.ammazzonserver.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService{
    
    @Autowired
    UtenteRegistratoRepository utenteRegistratoRepository;

    @Override
    public EsitoUtenteDto checkLogin(UtenteRegistrato utenteRegistrato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EsitoUtenteDto registrazione(UtenteRegistrato utenteRegistrato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
