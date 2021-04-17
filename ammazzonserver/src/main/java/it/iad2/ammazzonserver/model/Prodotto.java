package it.iad2.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Entity
public class Prodotto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 40)
    private String codice;

    @Column
    private String descrizione;

    @Column
    private Double prezzo;

    // relazione OneToMany con ProdottoColore
    @JsonIgnoreProperties(value = "prodotto", allowGetters = true, allowSetters = true)
    @OneToMany(mappedBy = "prodotto")
    private List<ProdottoColore> listaProdottoColore;

    public Prodotto() {
    }

    public Prodotto(String codice, String descrizione, Double prezzo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
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

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "id=" + id + ", codice=" + codice + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", listaProdottoColore=" + listaProdottoColore + '}';
    }

}
