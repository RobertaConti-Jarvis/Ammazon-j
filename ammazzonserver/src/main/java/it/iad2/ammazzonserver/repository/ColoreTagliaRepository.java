package it.iad2.ammazzonserver.repository;

import it.iad2.ammazzonserver.model.ColoreTaglia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoreTagliaRepository extends JpaRepository<ColoreTaglia, Long>{
    
}
