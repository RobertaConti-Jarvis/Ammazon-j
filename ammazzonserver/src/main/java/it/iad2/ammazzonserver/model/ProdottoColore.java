package it.iad2.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Entity
public class ProdottoColore implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    // relazione OneToMany ColoreTaglia
    @JsonIgnore
    @OneToMany(mappedBy = "prodottoColore")
    private List<ColoreTaglia> listaColoreTaglia;
    
    // relazione ManyToOne con Prodotto
    @JsonIgnoreProperties(value = "listaProdottoColore", allowGetters = true , allowSetters = true)
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Prodotto prodotto;
    
    // relazione ManyToOne con VarianteColore
    @JsonIgnoreProperties(value = "listaProdottoColore", allowGetters = true , allowSetters = true)
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private VarianteColore varianteColore;

    public ProdottoColore() {
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

    public Prodotto getProdotto() {
        if (prodotto == null) {
            prodotto = new Prodotto();
        }
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        if (prodotto == null) {
            prodotto = new Prodotto();
        }
        this.prodotto = prodotto;
    }

    public VarianteColore getVarianteColore() {
        if (varianteColore == null) {
            varianteColore = new VarianteColore();
        }
        return varianteColore;
    }

    public void setVarianteColore(VarianteColore varianteColore) {
        if (varianteColore == null) {
            varianteColore = new VarianteColore();
        }
        this.varianteColore = varianteColore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProdottoColore{" + "id=" + id + ", listaColoreTaglia=" + listaColoreTaglia + ", prodotto=" + prodotto + ", varianteColore=" + varianteColore + '}';
    }

    

}
