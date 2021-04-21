package it.iad2.ammazzonserver.serviceimpl;

import it.iad2.ammazzonserver.model.Ordine;
import it.iad2.ammazzonserver.repository.OrdineRepository;
import it.iad2.ammazzonserver.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    OrdineRepository ordineRepository;

    @Override
    public List<Ordine> filtraOrdini(String ordine, String tipo, String stato) {
        Sort ordinamento;
        Sort.Direction dir;
        if (ordine.equals("Crescente")){
            dir = Sort.Direction.ASC;
        } else {
            dir = Sort.Direction.DESC;
        }
        ordinamento = Sort.by(dir, tipo);
        return ordineRepository.findByStato(stato, ordinamento);
    }
}
