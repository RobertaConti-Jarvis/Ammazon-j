package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.CriterioRicercaDto;
import it.iad2.ammazzonserver.dto.ListaVarianteTaglieDto;
import it.iad2.ammazzonserver.dto.VarianteTagliaDto;
import it.iad2.ammazzonserver.service.GestioneTaglieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class GestioneTaglieController {

    final Logger logger = LoggerFactory.getLogger(GestioneTaglieController.class);

    @Autowired
    GestioneTaglieService gestioneTaglieService;

//  Ricerca
    @RequestMapping("/ricerca-taglie")
    @ResponseBody
    ListaVarianteTaglieDto ricerca(@RequestBody CriterioRicercaDto dto) {
        return new ListaVarianteTaglieDto(gestioneTaglieService.ricerca(dto.getCriterio()));
    }

//  Modifica
    @RequestMapping("/modifica-taglie")
    @ResponseBody
    ListaVarianteTaglieDto modifica(@RequestBody VarianteTagliaDto dto) {
        return new ListaVarianteTaglieDto(gestioneTaglieService.modifica(dto.getTaglia()));
    }

//  Aggiungi
    @RequestMapping("/aggiungi-taglie")
    @ResponseBody
    ListaVarianteTaglieDto aggiungi(@RequestBody VarianteTagliaDto dto) {
        return new ListaVarianteTaglieDto(gestioneTaglieService.aggiungi(dto.getTaglia()));
    }

//  Rimuovi
    @RequestMapping("/rimuovi-taglie")
    @ResponseBody
    ListaVarianteTaglieDto rimuovi(@RequestBody VarianteTagliaDto dto) {
        logger.debug("Entrati in rimuovi controller");
        return new ListaVarianteTaglieDto(gestioneTaglieService.rimuovi(dto.getTaglia()));
    }

//  Aggiorna
    @RequestMapping("/aggiorna-taglie")
    @ResponseBody
    ListaVarianteTaglieDto aggiorna() {
        return new ListaVarianteTaglieDto(gestioneTaglieService.aggiorna());
    }
}
