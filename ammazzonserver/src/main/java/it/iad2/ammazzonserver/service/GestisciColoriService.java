package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.dto.ListaVarianteColoreDto;
import it.iad2.ammazzonserver.model.VarianteColore;
import org.springframework.data.domain.Page;

public interface GestisciColoriService {

    ListaVarianteColoreDto cercaPerCodice(String criterio);

    ListaVarianteColoreDto rimuoviAction(VarianteColore varianteColore);

    ListaVarianteColoreDto aggiungiAction(VarianteColore varianteColore);

    ListaVarianteColoreDto modificaAction(VarianteColore varianteColore);

    ListaVarianteColoreDto aggiorna();

    Page<VarianteColore> elementiPaginati(int numPage, int elemPage);

}
