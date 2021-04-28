package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.BaseRequestDto;
import it.iad2.ammazzonserver.dto.EsitoDto;
import it.iad2.ammazzonserver.dto.EsitoUtenteDto;
import it.iad2.ammazzonserver.dto.UsernameDto;
import it.iad2.ammazzonserver.dto.UtenteRegistratoDto;
import it.iad2.ammazzonserver.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class SecurityController {
    @Autowired
    SecurityService securityService;
    
    @RequestMapping("/check-username")
    @ResponseBody
    EsitoDto checkusername(@RequestBody UsernameDto dto) {
        return new EsitoDto(securityService.checkUsername(dto.getUsername()));
    }
    
    @RequestMapping("/check-login")
    @ResponseBody
    EsitoUtenteDto checkLogin(@RequestBody UtenteRegistratoDto dto) {
        return securityService.checkLogin(dto.getUtenteRegistrato(), dto.getSessionToken());
    }
    
    @RequestMapping("/registrazione")
    @ResponseBody
    EsitoUtenteDto registrazione(@RequestBody UtenteRegistratoDto dto) {
        return securityService.registrazione(dto.getUtenteRegistrato(), dto.getSessionToken());
    }
    
    @RequestMapping("/check-token-reg")
    @ResponseBody
    EsitoUtenteDto checkTokenReg(@RequestBody BaseRequestDto dto) {
        return securityService.checkTokenReg(dto.getSessionToken());
    }
    
    @RequestMapping("/logout")
    @ResponseBody
    EsitoDto logout(@RequestBody BaseRequestDto dto) {
        return securityService.logout(dto.getSessionToken());
    }
    
    @RequestMapping("/aggiorna-dati")
    @ResponseBody
    EsitoUtenteDto aggiornaDati(@RequestBody UtenteRegistratoDto dto) {
        return securityService.aggiornaDati(dto.getUtenteRegistrato(),dto.getSessionToken());
    }
    
    @RequestMapping("/elimina-account")
    @ResponseBody
    EsitoUtenteDto eliminaAccount(@RequestBody UtenteRegistratoDto dto) {
        return securityService.eliminaAccount(dto.getUtenteRegistrato(),dto.getSessionToken());
    }
    
}
