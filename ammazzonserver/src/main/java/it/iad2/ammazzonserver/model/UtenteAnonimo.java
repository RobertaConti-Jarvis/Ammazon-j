package it.iad2.ammazzonserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//public class UtenteAnonimo implements Serializable {
public class UtenteAnonimo {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String tokenAnonimo;

    public UtenteAnonimo() {
    }

    public UtenteAnonimo(String tokenAnonimo) {
        this.tokenAnonimo = tokenAnonimo;
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
        return "UtenteAnonimo{" + "id=" + id + ", tokenAnonimo=" + tokenAnonimo + '}';
    }

}
