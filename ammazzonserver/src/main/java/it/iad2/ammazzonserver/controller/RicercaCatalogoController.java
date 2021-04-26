package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.CriterioDatiPageDto;
import it.iad2.ammazzonserver.dto.PageDto;
import it.iad2.ammazzonserver.service.RicercaCatalogoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class RicercaCatalogoController {

    Logger logger = LoggerFactory.getLogger(RicercaCatalogoController.class);
    
    @Autowired
    RicercaCatalogoService ricercaCatalogoService;

    @RequestMapping("/carica-catalogo-paginati")
    @ResponseBody
    public PageDto catalogoPaginati(@RequestBody CriterioDatiPageDto dto) {
        logger.debug(dto.toString());
        return new PageDto(ricercaCatalogoService.catalogoPaginati(dto.getCriterio(), dto.getNumPag(), dto.getElemPag()));
    }
}
