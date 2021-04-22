package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ListaColoreTaglieDto;
import it.iad2.ammazzonserver.dto.ListaProdottiColoriDto;
import it.iad2.ammazzonserver.dto.ListaVarianteTaglieDto;
import it.iad2.ammazzonserver.dto.PageDto;
import it.iad2.ammazzonserver.model.ColoreTaglia;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.ProdottoColore;
import it.iad2.ammazzonserver.model.VarianteTaglia;

public interface AssociaTaglieColoriProdService {
    /**
     * Consente una ricerca per codice esatto o per descrizione like dei prodotti
     * presenti in banca dati
     * @param criterio di tipo String, parametro di ricerca
     * @return ListaProdottiDto classe che contiene una lista di
     * @see Prodotto
     */
    PageDto cercaProdottiPerCodiceDescrizione(String criterio, int numPage, int elemPage);
    
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
     * @return ListaVarianteTaglieDto classe che contiene una lista di
     * @see VarianteTaglia
     */
    ListaVarianteTaglieDto mostraTaglieNonAssociateAProdottoColore(ProdottoColore prodColore);
    
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
     * @see VarianteTaglia
     * @param prodColore di tipo
     * @see ProdottoColore
     * @return ListaTaglieDto classe che contiene una lista di
     * @see ColoreTaglia
     */
    ListaColoreTaglieDto associaColoreTaglia(VarianteTaglia taglia, ProdottoColore prodColore);
    
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
