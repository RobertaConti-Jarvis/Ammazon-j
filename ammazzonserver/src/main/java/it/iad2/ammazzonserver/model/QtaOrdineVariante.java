package it.iad2.ammazzonserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QtaOrdineVariante {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int qta;
    
    // relazione OneToMany con Ordine
    // relazione OneToMany con ColoreTaglia

    public QtaOrdineVariante() {
    }

    public QtaOrdineVariante(int qta) {
        this.qta = qta;
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
        return "QtaOrdineVariante{" + "id=" + id + ", qta=" + qta + '}';
    }
    
    
}
