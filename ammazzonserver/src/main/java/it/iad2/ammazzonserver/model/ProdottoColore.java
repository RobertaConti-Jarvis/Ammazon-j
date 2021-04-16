package it.iad2.ammazzonserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProdottoColore {

    @Id
    @GeneratedValue
    private Long id;

    // relazione OneToMany ColoreTaglia
    // relazione ManyToOne con Prodotto
    // relazione ManyToOne con VarianteColore
    public ProdottoColore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProdottoColore{" + "id=" + id + '}';
    }

}
