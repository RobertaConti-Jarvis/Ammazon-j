
package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.dto.ListaVarianteColoreDto;
import it.iad2.ammazzonserver.model.VarianteColore;


public interface GestisciColoriService {

    ListaVarianteColoreDto cercaPerCodice(String criterio);

    ListaVarianteColoreDto rimuoviAction(VarianteColore varianteColore);

    ListaVarianteColoreDto aggiungiAction(VarianteColore varianteColore);

    ListaVarianteColoreDto modificaAction(VarianteColore varianteColore);
    
    ListaVarianteColoreDto aggiorna();
    
    

}
