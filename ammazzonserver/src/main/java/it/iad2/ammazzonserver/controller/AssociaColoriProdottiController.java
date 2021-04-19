package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.CriterioRicercaDto;
import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.service.AssociaColoriProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AssociaColoriProdottiController {
    
    @Autowired
    AssociaColoriProdottiService associaColoriProdottiService;
    
    @RequestMapping("/cerca-prodotti")
    @ResponseBody
    
    public ListaProdottiDto cercaProdotto(@RequestBody CriterioRicercaDto dto) {
        return associaColoriProdottiService.cercaProdotto(dto.getCriterio());
    }
}