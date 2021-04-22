/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.DatiOrdinePageDto;
import it.iad2.ammazzonserver.dto.PageDto;
import it.iad2.ammazzonserver.service.MostraCarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utente
 */
@RestController
@CrossOrigin("*")

public class MostraCarrelloController {

    @Autowired
    MostraCarrelloService mostraCarrelloService;

    @RequestMapping("/mostra-carrello")
    @ResponseBody
    public PageDto mostraCarrello(@RequestBody DatiOrdinePageDto dto) {
        return new PageDto(mostraCarrelloService.mostraCarrello(dto.getElemPag(), dto.getNumPag(), dto.getOrdine()));
    }

}
