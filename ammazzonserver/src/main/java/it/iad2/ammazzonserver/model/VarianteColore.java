package it.iad2.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Entity
public class VarianteColore implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String codice;

    @Column
    private String descrizione;

    // relazione OneToMany ProdottoColore
    @OneToMany(mappedBy = "varianteColore")
    @JsonIgnoreProperties(value = "varianteColore")
    private List<ProdottoColore> listaProdottoColore;

    public VarianteColore() {
    }

    public VarianteColore(String codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    public List<ProdottoColore> getListaProdottoColore() {
        if (listaProdottoColore == null) {
            listaProdottoColore = new ArrayList<>();
        }
        return listaProdottoColore;
    }

    public void setListaProdottoColore(List<ProdottoColore> listaProdottoColore) {
        if (listaProdottoColore == null) {
            listaProdottoColore = new ArrayList<>();
        }
        this.listaProdottoColore = listaProdottoColore;
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
        return "VarianteColore{" + "id=" + id + ", codice=" + codice + ", descrizione=" + descrizione + ", listaProdottoColore=" + listaProdottoColore + '}';
    }

}
