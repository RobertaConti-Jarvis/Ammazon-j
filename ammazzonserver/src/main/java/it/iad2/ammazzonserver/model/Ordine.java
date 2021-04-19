package it.iad2.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Ordine implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDate data;

    @Column
    private int numero;

    @Column
    private String stato = "CARRELLO";

    // relazione OneToOne UtenteAnonimo
    @JsonIgnore
    @OneToOne(mappedBy = "ordine")
    private UtenteAnonimo utenteAnonimo;
    // relazione ManyToOne UtenteRegistrato
    @JsonIgnoreProperties(value = "listaOrdine", allowGetters = true, allowSetters = true)
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private UtenteRegistrato utenteRegistrato;
    // relazione OneToMany con QtaOrdiniVariante
    @JsonIgnore
    @OneToMany(mappedBy = "ordine")
    private List<QtaOrdineVariante> listaQtaOrdineVariante;

    public Ordine() {
    }

    public Ordine(LocalDate data, int numero) {
        this.data = data;
        this.numero = numero;
    }

    public UtenteAnonimo getUtenteAnonimo() {
        return utenteAnonimo;
    }

    public void setUtenteAnonimo(UtenteAnonimo utenteAnonimo) {
        this.utenteAnonimo = utenteAnonimo;
    }

    public UtenteRegistrato getUtenteRegistrato() {
        return utenteRegistrato;
    }

    public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
        this.utenteRegistrato = utenteRegistrato;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Ordine{" + "id=" + id + ", data=" + data + ", numero=" + numero + ", stato=" + stato + ", utenteAnonimo=" + utenteAnonimo + ", utenteRegistrato=" + utenteRegistrato + ", listaQtaOrdineVariante=" + listaQtaOrdineVariante + '}';
    }

}
