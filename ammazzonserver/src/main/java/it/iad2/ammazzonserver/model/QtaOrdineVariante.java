package it.iad2.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class QtaOrdineVariante implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int qta;

    // relazione ManyToOne con Ordine
    @JsonIgnoreProperties(value = "listaQtaOrdineVariante", allowGetters = true, allowSetters = true)
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Ordine ordine;
    // relazione ManyToOne con ColoreTaglia
    @JsonIgnoreProperties(value = "listaQtaOrdineVariante", allowGetters = true, allowSetters = true)
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ColoreTaglia coloreTaglia;

    public QtaOrdineVariante() {
    }

    public QtaOrdineVariante(int qta) {
        this.qta = qta;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public ColoreTaglia getColoreTaglia() {
        return coloreTaglia;
    }

    public void setColoreTaglia(ColoreTaglia coloreTaglia) {
        this.coloreTaglia = coloreTaglia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    @Override
    public String toString() {
        return "QtaOrdineVariante{" + "id=" + id + ", qta=" + qta + ", ordine=" + ordine + ", coloreTaglia=" + coloreTaglia + '}';
    }

}
