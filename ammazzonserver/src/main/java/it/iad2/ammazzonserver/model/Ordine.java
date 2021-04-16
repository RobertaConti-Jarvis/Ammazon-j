package it.iad2.ammazzonserver.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ordine {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDate data;

    @Column
    private int numero;

    @Column
    private String stato = "CARRELLO";

    // relazione ManyToOne UtenteRegistrato
    // relazione ManyToOne con QtaOrdiniVariante
    public Ordine() {
    }

    public Ordine(LocalDate data, int numero) {
        this.data = data;
        this.numero = numero;
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
        return "Ordine{" + "id=" + id + ", data=" + data + ", numero=" + numero + ", stato=" + stato + '}';
    }

}
