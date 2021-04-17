package it.iad2.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Entity
public class ColoreTaglia implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int giacenza;

    // relazione OneToMany QtaOrdineVariante
    @JsonIgnoreProperties(value = "coloreTaglia", allowGetters = true, allowSetters = true)
    @OneToMany(mappedBy = "coloreTaglia")
    private List<QtaOrdineVariante> listaQtaOrdineVariante;
    // relazione ManyToOne con VarianteTaglia
    @JsonIgnoreProperties(value = "listaColoreTaglia", allowGetters = true, allowSetters = true)
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private VarianteTaglia varianteTaglia;
    // relazione ManyToOne con ProdottoColore
    @JsonIgnoreProperties(value = "listaColoreTaglia", allowGetters = true, allowSetters = true)
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ProdottoColore prodottoColore;

    public ColoreTaglia() {
    }

    public ColoreTaglia(int giacenza) {
        this.giacenza = giacenza;
    }

    public List<QtaOrdineVariante> getListaQtaOrdineVariante() {
        if (listaQtaOrdineVariante == null) {
            listaQtaOrdineVariante = new ArrayList<>();
        }
        return listaQtaOrdineVariante;
    }

    public void setListaQtaOrdineVariante(List<QtaOrdineVariante> listaQtaOrdineVariante) {
        if (listaQtaOrdineVariante == null) {
            listaQtaOrdineVariante = new ArrayList<>();
        }
        this.listaQtaOrdineVariante = listaQtaOrdineVariante;
    }

    public VarianteTaglia getVarianteTaglia() {
        return varianteTaglia;
    }

    public void setVarianteTaglia(VarianteTaglia varianteTaglia) {
        this.varianteTaglia = varianteTaglia;
    }

    public ProdottoColore getProdottoColore() {
        return prodottoColore;
    }

    public void setProdottoColore(ProdottoColore prodottoColore) {
        this.prodottoColore = prodottoColore;
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
        return "ColoreTaglia{" + "id=" + id + ", giacenza=" + giacenza + ", listaQtaOrdineVariante=" + listaQtaOrdineVariante + ", varianteTaglia=" + varianteTaglia + ", prodottoColore=" + prodottoColore + '}';
    }

}
