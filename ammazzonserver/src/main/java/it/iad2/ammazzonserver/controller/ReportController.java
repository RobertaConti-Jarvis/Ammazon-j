package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.dto.DatiPageDto;
import it.iad2.ammazzonserver.dto.FiltriOrdiniDto;
import it.iad2.ammazzonserver.dto.ListaOrdiniDto;
import it.iad2.ammazzonserver.dto.PageOrdineDto;
import it.iad2.ammazzonserver.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class ReportController {

    @Autowired
    ReportService reportService;

    @RequestMapping("/filtra-ordini")
    @ResponseBody
    public ListaOrdiniDto filtraOrdini(@RequestBody FiltriOrdiniDto dto) {
        return new ListaOrdiniDto(reportService.filtraOrdini(dto.getOrdine(), dto.getTipo(), dto.getStato()));
    }

    @RequestMapping("/carica-ordini-paginati")
    @ResponseBody
    public PageOrdineDto caricaOrdiniPage(@RequestBody DatiPageDto dto) {
        return new PageOrdineDto(reportService.elementiPaginatiReport(dto.getNumPag(), dto.getElemPag()));
    }
}
