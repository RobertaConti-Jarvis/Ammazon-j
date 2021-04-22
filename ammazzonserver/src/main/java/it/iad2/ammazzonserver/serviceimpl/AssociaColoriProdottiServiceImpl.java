package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.dto.ListaProdottiDto;
import it.iad2.ammazzonserver.dto.ListeColoriProdottoDto;
import it.iad2.ammazzonserver.dto.ProdottoColoreDto;
import it.iad2.ammazzonserver.model.Prodotto;
import it.iad2.ammazzonserver.model.ProdottoColore;
import it.iad2.ammazzonserver.model.VarianteColore;
import it.iad2.ammazzonserver.repository.ProdottoColoreRepository;
import it.iad2.ammazzonserver.repository.ProdottoRepository;
import it.iad2.ammazzonserver.repository.VarianteColoreRepository;
import it.iad2.ammazzonserver.service.AssociaColoriProdottiService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociaColoriProdottiServiceImpl implements AssociaColoriProdottiService {

    @Autowired
    ProdottoRepository prodottoRepository;
    @Autowired
    ProdottoColoreRepository prodottoColoreRepository;

    @Autowired
    VarianteColoreRepository varianteColoreRepository;

    @Override
    public ListaProdottiDto cercaProdotto(String criterio) {
        return new ListaProdottiDto(prodottoRepository.cercaPerCriterio(criterio, "%" + criterio + "%"));
    }

    @Override
    public ListeColoriProdottoDto seleziona(Prodotto p) {

        List<VarianteColore> listaColoriAssociati = prodottoColoreRepository.selezionaColoriAssociatiProdotto(p.getId());

        List<VarianteColore> listaColoriNonAssociati = prodottoColoreRepository.selezionaColoriNonAssociatiProdotto(p.getId());

        List<VarianteColore> listatuttiColori = varianteColoreRepository.findAll();

        List<VarianteColore> listaSelezionati = new ArrayList<>();
        
            listaSelezionati = listatuttiColori;
      
        return new ListeColoriProdottoDto(listaColoriAssociati, listaColoriNonAssociati);

//        return new ListeColoriProdottoDto(listaColoriAssociati, listaColoriNonAssociati);
//        List<VarianteColore> listaColoriNonAssociati = varianteColoreRepository.findAll();
//        List<VarianteColore> listaColoritutti = varianteColoreRepository.findAll();
//        List<VarianteColore>listaSelezionati = new ArrayList<>();
//        for(VarianteColore vc: listaColoritutti ){
//           for(VarianteColore vv: listaSelezionati){
//               if (vv.getId() != vc.getId()){
//                   listaSelezionati.add(vv);
//               }
//               
//           }
//            
//        }
        //return new ListeColoriProdottoDto(listaColoriAssociati, listaColoriNonAssociati);
    }

    @Override
    public ListeColoriProdottoDto spostaInDisponibili(ProdottoColoreDto dto) {
        ProdottoColore prodottoColore = dto.getProdottoColore();
        Prodotto prodotto = prodottoColore.getProdotto();
        VarianteColore varianteColore = prodottoColore.getVarianteColore();
        prodottoColore = prodottoColoreRepository.disassociaProdottoColore(prodotto.getId(), varianteColore.getId());
        prodottoColoreRepository.deleteById(prodottoColore.getId());
        

        List<VarianteColore> listaColoriAssociati = prodottoColoreRepository.selezionaColoriAssociatiProdotto(prodotto.getId());

        List<VarianteColore> listaColoriNonAssociati = prodottoColoreRepository.selezionaColoriNonAssociatiProdotto(prodotto.getId());
        return new ListeColoriProdottoDto(listaColoriAssociati, listaColoriNonAssociati);
    }

    @Override
    public ListeColoriProdottoDto spostaInAssociati(ProdottoColoreDto dto) {
        ProdottoColore prodottoColore = dto.getProdottoColore();
        prodottoColore = prodottoColoreRepository.save(prodottoColore);
        Prodotto prodotto = prodottoColore.getProdotto();
        List<VarianteColore> listaColoriAssociati = prodottoColoreRepository.selezionaColoriAssociatiProdotto(prodotto.getId());

        List<VarianteColore> listaColoriNonAssociati = prodottoColoreRepository.selezionaColoriNonAssociatiProdotto(prodotto.getId());
        return new ListeColoriProdottoDto(listaColoriAssociati, listaColoriNonAssociati);

    }

}
