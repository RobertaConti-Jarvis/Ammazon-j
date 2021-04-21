package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.model.Ordine;

import java.util.List;
import org.springframework.data.domain.Page;

public interface ReportService {

    List<Ordine> filtraOrdini(String ordine, String tipo, String stato);

    Page<Ordine> elementiPaginatiReport(int numPage, int elemPage);
}
