package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.ColoreTagliaDto;
import it.iad2.ammazzonserver.dto.EsitoDto;
import it.iad2.ammazzonserver.dto.OrdineDto;
import it.iad2.ammazzonserver.service.GestioneCarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class GestioneCarrelloController {

    @Autowired
    GestioneCarrelloService gestioneCarrelloService;

    @RequestMapping("/aggiungi-carrello")
    @ResponseBody
    public OrdineDto aggiungiCarrello(@RequestBody ColoreTagliaDto dto) {
        return gestioneCarrelloService.aggiungiCarrello(dto.getColoreTaglia(), dto.getSessionToken());
    }
    
    @RequestMapping("/esito-pagamento")
    @ResponseBody
    public EsitoDto esitoPagamento(@RequestBody OrdineDto dto){
        return new EsitoDto(gestioneCarrelloService.esitoPagamento(dto.getOrdine()));
    }
}
