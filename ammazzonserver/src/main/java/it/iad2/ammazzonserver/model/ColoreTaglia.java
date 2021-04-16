package it.iad2.ammazzonserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ColoreTaglia {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int giacenza;

    // relazione ManyToOne QtaOrdineVariante
    // relazione OneToMany con VarianteTaglia
    // relazione OneToMany con ProdottoColore
    public ColoreTaglia() {
    }

    public ColoreTaglia(int giacenza) {
        this.giacenza = giacenza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
    }

    @Override
    public String toString() {
        return "ColoreTaglia{" + "id=" + id + ", giacenza=" + giacenza + '}';
    }

}
