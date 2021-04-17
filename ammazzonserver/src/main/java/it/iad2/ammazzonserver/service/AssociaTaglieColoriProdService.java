package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ListaColoreTaglieDto;
import it.iad2.ammazzonserver.dto.ListaProdottiColoriDto;
import it.iad2.ammazzonserver.dto.ListaVarianteColoreDto;
import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.ProdottoColore;

public interface AssociaTaglieColoriProdService {
    /**
     * Consente una ricerca per codice esatto o per descrizione like dei prodotti
     * presenti in banca dati
     * @param criterio di tipo String, parametro di ricerca
     * @return ListaProdottiDto classe che contiene una lista di
     * @see Prodotto
     */
    ListaProdottiDto cercaProdottiPerCodiceDescrizione(String criterio);
    
    /**
     * Mostra una lista di colori associati al prodotto selezionato
     * @param prodotto di tipo Prodotto
     * @see Prodotto
     * @return ListaProdottiColoriDto classe che contiene una lista di
     * @see ProdottoColore
     */
    ListaProdottiColoriDto mostraColoriAssociatiAProdotto(Prodotto prodotto);
    
    /**
     * Mostra una lista di taglie associate al prodotto-colore selezionato
     * @param prodColore criterio di ricerca di tipo
     * @see ProdottoColore
     * @return ListaTaglieDto classe che contiene una lista di
     * @see ColoreTaglia
     */
    ListaColoreTaglieDto mostraTaglieAssociateAProdottoColore(ProdottoColore prodColore);
    
    /**
     * Mostra una lista di taglie non associate al prodotto-colore selezionato
     * @param prodColore criterio di ricerca di tipo
     * @see ProdottoColore
     * @return ListaTaglieDto classe che contiene una lista di
     * @see ColoreTaglia
     */
    ListaColoreTaglieDto mostraTaglieNonAssociateAProdottoColore(ProdottoColore prodColore);
    
    /**
     * Disassocia la taglia selezionata dal ProdottoColore
     * @param taglia di tipo
     * @see Taglia
     * @param prodColore di tipo
     * @see ProdottoColore
     * @return ListaTaglieDto classe che contiene una lista di
     * @see ColoreTaglia
     */
    ListaColoreTaglieDto rimuoviColoreTaglia(ColoreTaglia taglia, ProdottoColore prodColore);
    
    /**
     * Associa la taglia selezionata al ProdottoColore
     * @param taglia di tipo
     * @see Taglia
     * @param prodColore di tipo
     * @see ProdottoColore
     * @return ListaTaglieDto classe che contiene una lista di
     * @see ColoreTaglia
     */
    ListaColoreTaglieDto associaColoreTaglia(ColoreTaglia taglia, ProdottoColore prodColore);
    
    /**
     * Associa tutte le taglie al ProdottoColore
     * @param prodColore di tipo
     * @see ProdottoColore
     * @return ListaTaglieDto classe che contiene una lista di
     * @see ColoreTaglia
     */
    ListaColoreTaglieDto associaTuttiColoriTaglie(ProdottoColore prodColore);
    
    /**
     * Disassocia tutte le taglie al ProdottoColore
     * @param prodColore di tipo
     * @see ProdottoColore
     * @return ListaTaglieDto classe che contiene una lista di
     * @see ColoreTaglia
     */
    ListaColoreTaglieDto disassociaTuttiColoriTaglie(ProdottoColore prodColore);
}
