package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.model.VarianteTaglia;
import java.util.List;

public interface GestioneTaglieService {
    /**
     * Effettua una ricerca per taglia inserita
     * @param criterio criterio di ricerca per codice taglia
     * @return Lista Variante della taglie disponibili
     */
    List<VarianteTaglia> ricerca(String criterio);
    
    /**
     * Effettua una modifica taglia 
     * @param taglia di tipo VarianteTaglia
     * @return Lista Variante taglie dopo la modifica
     */
    List<VarianteTaglia> modifica(VarianteTaglia taglia);
    
    /**
     * Aggiunge una taglia 
     * @param taglia di tipo VarianteTaglia
     * @return Lista Variante taglie dopo l'aggiunta
     */
    List<VarianteTaglia> aggiungi(VarianteTaglia taglia);
    
    /**
     * Rimuove una taglia
     * @param taglia di tipo VarianteTaglia
     * @return Lista Variante taglie dopo la rimozione
     */
    List<VarianteTaglia> rimuovi(VarianteTaglia taglia);
    
    /**
     * Restituisce la lista di taglie preseenti
     * @return lista di taglie
     */
    List<VarianteTaglia> aggiorna();
    
    
}
