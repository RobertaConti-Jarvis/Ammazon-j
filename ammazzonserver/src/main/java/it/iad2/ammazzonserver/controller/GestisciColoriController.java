
package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.CriterioRicercaDto;
import it.iad2.ammazzonserver.dto.ListaVarianteColoreDto;
import it.iad2.ammazzonserver.dto.VarianteColoreDto;
import it.iad2.ammazzonserver.service.GestisciColoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class GestisciColoriController {
    
    @Autowired
    GestisciColoriService gestisciColoriService;
    

    //rimuoviAction
    @RequestMapping("/rimuovi-variante-colore")
    @ResponseBody
    ListaVarianteColoreDto rimuoviAction(@RequestBody VarianteColoreDto dto){
        return gestisciColoriService.rimuoviAction(dto.getVarianteColore());
    }

    //aggiungiAction
    @RequestMapping("/aggiungi-variante-colore")
    @ResponseBody
    ListaVarianteColoreDto aggiungiAction(@RequestBody VarianteColoreDto dto){
       return gestisciColoriService.aggiungiAction(dto.getVarianteColore());
    }

    //modificaAction
    @RequestMapping("modifica-variante-colore")
    @ResponseBody
    ListaVarianteColoreDto modificaAction(@RequestBody VarianteColoreDto dto){
       return gestisciColoriService.aggiungiAction(dto.getVarianteColore());
    }

    //cercaPerCodice
    @RequestMapping("cerca-variante-colore")
    @ResponseBody
    ListaVarianteColoreDto cercaPerCodice(@RequestBody CriterioRicercaDto dto){
        return gestisciColoriService.cercaPerCodice(dto.getCriterio());
    }

    
    //aggiorna
    @RequestMapping("aggiorna-variante-colore")
    @ResponseBody
    ListaVarianteColoreDto aggiorna(){
       return gestisciColoriService.aggiorna();
    }
    

}
