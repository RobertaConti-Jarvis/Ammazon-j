package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.ColoreTagliaDto;
import it.iad2.ammazzonserver.dto.CriterioRicercaDto;
import it.iad2.ammazzonserver.dto.ListaColoreTaglieDto;
import it.iad2.ammazzonserver.dto.ListaProdottiColoriDto;
import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ListaVarianteTaglieDto;
import it.iad2.ammazzonserver.dto.ProdottoColoreDto;
import it.iad2.ammazzonserver.dto.ProdottoDto;
import it.iad2.ammazzonserver.service.AssociaTaglieColoriProdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AssociaTaglieColoriProdController {

    private final Logger logger = LoggerFactory.getLogger(AssociaTaglieColoriProdController.class);

    @Autowired
    AssociaTaglieColoriProdService associaTaglieCPService;

    @RequestMapping("/cerca-prodotti-criterio")
    @ResponseBody
    public ListaProdottiDto mostraProdottiPerCodiceDescrizione(@RequestBody CriterioRicercaDto dto) {
        return associaTaglieCPService.cercaProdottiPerCodiceDescrizione(dto.getCriterio());
    }

    @RequestMapping("/mostra-prodotto-colori")
    @ResponseBody
    public ListaProdottiColoriDto mostraProdottoColori(@RequestBody ProdottoDto dto) {
        return associaTaglieCPService.mostraColoriAssociatiAProdotto(dto.getProdotto());
    }

    @RequestMapping("/mostra-coloretaglie-associate")
    @ResponseBody
    public ListaColoreTaglieDto mostraColoreTaglieAssociate(@RequestBody ProdottoColoreDto dto) {
        return associaTaglieCPService.mostraTaglieAssociateAProdottoColore(dto.getProdottoColore());
    }

    @RequestMapping("/mostra-coloretaglie-disponibili")
    @ResponseBody
    public ListaVarianteTaglieDto mostraColoreTaglieDisponibili(@RequestBody ProdottoColoreDto dto) {
        return associaTaglieCPService.mostraTaglieNonAssociateAProdottoColore(dto.getProdottoColore());
    }

    @RequestMapping("/rimuovi-colore-taglia")
    @ResponseBody
    public ListaColoreTaglieDto rimuoviColoreTaglia(@RequestBody ColoreTagliaDto dto) {
        logger.debug("Controller rimuoviColoreTaglia");
        return associaTaglieCPService.rimuoviColoreTaglia(dto.getColoreTaglia(), dto.getColoreTaglia().getProdottoColore());
    }

    @RequestMapping("/associa-colore-taglia")
    @ResponseBody
    public ListaColoreTaglieDto associaColoreTaglia(@RequestBody ColoreTagliaDto dto) {
        return associaTaglieCPService.associaColoreTaglia(dto.getColoreTaglia().getVarianteTaglia(), dto.getColoreTaglia().getProdottoColore());
    }

    @RequestMapping("/associa-tutti-colore-taglia")
    @ResponseBody
    public ListaColoreTaglieDto associaTuttiColoreTaglia(@RequestBody ProdottoColoreDto dto) {
        return associaTaglieCPService.associaTuttiColoriTaglie(dto.getProdottoColore());
    }

    @RequestMapping("/disassocia-tutti-colore-taglia")
    @ResponseBody
    public ListaColoreTaglieDto disassociaTuttiColoreTaglia(@RequestBody ProdottoColoreDto dto) {
        //TODO
        return null;
    }

}
