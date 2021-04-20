package it.iad2.ammazzonserver.service;

import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ListeColoriProdottoDto;
import it.iad2.ammazzonserver.dto.ProdottoDto;
import it.iad2.ammazzonserver.model.Prodotto;
import org.springframework.web.bind.annotation.RequestBody;

public interface AssociaColoriProdottiService {

    ListaProdottiDto cercaProdotto(String criterio);

    ListeColoriProdottoDto seleziona(Prodotto p);

}
