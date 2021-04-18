/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.ListaVarianteColoreDto;
import it.iad2.ammazzonserver.model.VarianteColore;
import it.iad2.ammazzonserver.repository.VarianteColoreRepository;
import it.iad2.ammazzonserver.service.GestisciColoriService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GestisciColoriServiceImpl implements GestisciColoriService {

    @Autowired
    VarianteColoreRepository varianteColoreRepository;

    @Override
    public ListaVarianteColoreDto cercaPerCodice(String criterio) {
        return new ListaVarianteColoreDto(varianteColoreRepository.findByCodiceContains(criterio));
    }

    @Override
    public ListaVarianteColoreDto rimuoviAction(VarianteColore varianteColore) {
        varianteColoreRepository.delete(varianteColore);
        return aggiorna();
    }

    @Override
    public ListaVarianteColoreDto aggiungiAction(VarianteColore varianteColore) {
        varianteColoreRepository.save(varianteColore);
        return aggiorna();
    }

    @Override
    public ListaVarianteColoreDto modificaAction(VarianteColore varianteColore) {
        varianteColoreRepository.save(varianteColore);
        return aggiorna();
    }

    @Override
    public ListaVarianteColoreDto aggiorna() {
        return new ListaVarianteColoreDto(varianteColoreRepository.findAll());

    }

}
