
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //aggiungiAction
    @RequestMapping("/aggiungi-variante-colore")
    @ResponseBody
    ListaVarianteColoreDto aggiungiAction(@RequestBody VarianteColoreDto dto){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //modificaAction
    @RequestMapping("modifica-variante-colore")
    @ResponseBody
    ListaVarianteColoreDto modificaAction(@RequestBody VarianteColoreDto dto){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //cercaPerCodice
    @RequestMapping("cerca-variante-colore")
    @ResponseBody
    ListaVarianteColoreDto cercaPerCodice(@RequestBody CriterioRicercaDto dto){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //aggiorna
    @RequestMapping("")
    @ResponseBody
    ListaVarianteColoreDto aggiorna(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
