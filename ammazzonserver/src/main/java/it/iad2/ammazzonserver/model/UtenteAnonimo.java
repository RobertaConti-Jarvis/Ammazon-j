package it.iad2.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import javax.persistence.Table;

@Entity
@Table(name = "Utente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UtenteAnonimo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String tokenAnonimo;

    // relazione OneToOne con Ordine
    @JsonIgnoreProperties(value = "utenteAnonimo", allowGetters = true, allowSetters = true)
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Ordine ordine;

    public UtenteAnonimo() {
    }

    public UtenteAnonimo(String tokenAnonimo) {
        this.tokenAnonimo = tokenAnonimo;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenAnonimo() {
        return tokenAnonimo;
    }

    public void setTokenAnonimo(String tokenAnonimo) {
        this.tokenAnonimo = tokenAnonimo;
    }

    @Override
    public String toString() {
        return "UtenteAnonimo{" + "id=" + id + ", tokenAnonimo=" + tokenAnonimo
                + ", ordine=" + ordine == null ? null : ordine.getId() + "}";
    }

}
