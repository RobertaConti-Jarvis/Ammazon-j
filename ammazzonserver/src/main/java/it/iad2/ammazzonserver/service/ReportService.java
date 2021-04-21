package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.model.Ordine;

import java.util.List;

public interface ReportService {

    List<Ordine> filtraOrdini(String ordine, String tipo, String stato);
}
