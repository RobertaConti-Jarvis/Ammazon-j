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
public class VarianteTaglia implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String codice;

    // relazione OneToMany ColoreTaglia
    @JsonIgnoreProperties(value = "varianteTaglia")
    @OneToMany(mappedBy = "varianteTaglia")
    private List<ColoreTaglia> listaColoreTaglia;

    public VarianteTaglia() {
    }

    public VarianteTaglia(String codice) {
        this.codice = codice;
    }

    public List<ColoreTaglia> getListaColoreTaglia() {
        if (listaColoreTaglia == null) {
            listaColoreTaglia = new ArrayList<>();
        }
        return listaColoreTaglia;
    }

    public void setListaColoreTaglia(List<ColoreTaglia> listaColoreTaglia) {
        if (listaColoreTaglia == null) {
            listaColoreTaglia = new ArrayList<>();
        }
        this.listaColoreTaglia = listaColoreTaglia;
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
        return "VarianteTaglia{" + "id=" + id + ", codice=" + codice + ", listaColoreTaglia=" + listaColoreTaglia + '}';
    }

}
