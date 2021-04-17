package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.CriterioRicercaDto;
import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ProdottoDto;
import it.iad2.ammazzonserver.service.AnagraficaProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class AnagraficaProdottoController {

    @Autowired
    AnagraficaProdottoService anagraficaProdottoService;

    @RequestMapping("/aggiungi-prodotto")
    @ResponseBody
    public ListaProdottiDto aggiungiProdotto(@RequestBody ProdottoDto dto) {
        return new ListaProdottiDto(anagraficaProdottoService.aggiungiProdotto(dto.getProdotto()));
    }

    @RequestMapping("/modifica-prodotto")
    @ResponseBody
    public ListaProdottiDto modificaProdotto(@RequestBody ProdottoDto dto) {
        return new ListaProdottiDto(anagraficaProdottoService.modificaProdotto(dto.getProdotto()));
    }

    @RequestMapping("/rimuovi-prodotto")
    @ResponseBody
    public ListaProdottiDto rimuoviProdotto(@RequestBody ProdottoDto dto) {
        return new ListaProdottiDto(anagraficaProdottoService.rimuoviProdotto(dto.getProdotto()));
    }

    @RequestMapping("/aggiorna-prodotto")
    @ResponseBody
    public ListaProdottiDto aggiornaProdotto() {
        return new ListaProdottiDto(anagraficaProdottoService.aggiornaProdotto());
    }

    @RequestMapping("/cerca-prodotto")
    @ResponseBody
    public ListaProdottiDto cercaProdotto(@RequestBody CriterioRicercaDto dto) {
        return new ListaProdottiDto(anagraficaProdottoService.cercaProdotto(dto.getCriterio()));
    }
}
