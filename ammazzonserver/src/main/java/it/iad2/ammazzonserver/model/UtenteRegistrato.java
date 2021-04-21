package it.iad2.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Entity
public class UtenteRegistrato extends UtenteAnonimo implements Serializable{

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String codiceFiscale;

    @Column
    private String tokenRegistrato;

    @Column
    private String email;

    // relazione OneToMany con Ordini
    @JsonIgnore
    @OneToMany(mappedBy = "utenteRegistrato")
    private List<Ordine> listaOrdine;

    public UtenteRegistrato() {
    }

    public UtenteRegistrato(String nome, String cognome, String username, String password, String codiceFiscale, String tokenRegistrato, String email, String tokenAnonimo) {
        super(tokenAnonimo);
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.codiceFiscale = codiceFiscale;
        this.tokenRegistrato = tokenRegistrato;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     
        
    public List<Ordine> getListaOrdine() {
        if (listaOrdine == null) {
            listaOrdine = new ArrayList<>();
        }
        return listaOrdine;
    }

    public void setListaOrdine(List<Ordine> listaOrdine) {
        if (listaOrdine == null) {
            listaOrdine = new ArrayList<>();
        }
        this.listaOrdine = listaOrdine;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getTokenRegistrato() {
        return tokenRegistrato;
    }

    public void setTokenRegistrato(String tokenRegistrato) {
        this.tokenRegistrato = tokenRegistrato;
    }

    @Override
    public String toString() {
        return "UtenteRegistrato{" + "nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password=" + password + ", codiceFiscale=" + codiceFiscale + ", tokenRegistrato=" + tokenRegistrato + ", email=" + email + ", listaOrdine=" + listaOrdine + '}';
    }

    

}
