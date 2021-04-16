package it.iad2.ammazzonserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VarianteColore {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String codice;

    @Column
    private String descrizione;

    // relazione OneToMany ProdottoColore
    public VarianteColore() {
    }

    public VarianteColore(String codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "VarianteColore{" + "id=" + id + ", codice=" + codice + ", descrizione=" + descrizione + '}';
    }

}
