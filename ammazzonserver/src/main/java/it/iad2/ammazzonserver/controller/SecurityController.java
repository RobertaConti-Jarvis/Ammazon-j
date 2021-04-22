package it.iad2.ammazzonserver.controller;

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
    
    @RequestMapping("/check-login")
    @ResponseBody
    EsitoUtenteDto checkLogin(@RequestBody UtenteRegistratoDto dto) {
        return securityService.checkLogin(dto.getUtenteRegistrato());
    }
    @RequestMapping("/check-username")
    @ResponseBody
    EsitoDto checkusername(@RequestBody UsernameDto dto) {
        return new EsitoDto(securityService.checkUsername(dto.getUsername()));
    }
    
    @RequestMapping("/registrazione")
    @ResponseBody
    EsitoUtenteDto registrazione(@RequestBody UtenteRegistratoDto dto) {
        return securityService.registrazione(dto.getUtenteRegistrato());
    }
}
