package it.iad2.ammazzonserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VarianteTaglia {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String codice;

    // relazione ManyToOne ColoreTaglia
    public VarianteTaglia() {
    }

    public VarianteTaglia(String codice) {
        this.codice = codice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    @Override
    public String toString() {
        return "VarianteTaglia{" + "id=" + id + ", codice=" + codice + '}';
    }

}
