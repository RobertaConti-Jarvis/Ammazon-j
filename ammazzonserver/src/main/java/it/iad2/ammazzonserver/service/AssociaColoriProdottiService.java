package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ListeColoriProdottoDto;
import it.iad2.ammazzonserver.dto.ProdottoColoreDto;
import it.iad2.ammazzonserver.model.Prodotto;

public interface AssociaColoriProdottiService {

    ListaProdottiDto cercaProdotto(String criterio);

    ListeColoriProdottoDto seleziona(Prodotto p);
    
    ListeColoriProdottoDto spostaInDisponibili(ProdottoColoreDto dto);

}
