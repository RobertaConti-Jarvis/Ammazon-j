package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.CriterioDatiPageDto;
import it.iad2.ammazzonserver.dto.PageDto;
import it.iad2.ammazzonserver.service.RicercaCatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class RicercaCatalogoController {

    @Autowired
    RicercaCatalogoService ricercaCatalogoService;

    @RequestMapping("/carica-catalogo-paginati")
    @ResponseBody
    public PageDto catalogoPaginati(@RequestBody CriterioDatiPageDto dto) {
        return new PageDto(ricercaCatalogoService.catalogoPaginati(dto.getCriterio(), dto.getNumPag(), dto.getElemPag()));
    }
}
