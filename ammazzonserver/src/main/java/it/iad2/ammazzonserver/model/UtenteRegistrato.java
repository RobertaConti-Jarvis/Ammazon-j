package it.iad2.ammazzonserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class UtenteRegistrato extends UtenteAnonimo {

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

    // relazione OneToMany con Ordini
    public UtenteRegistrato() {
    }

    public UtenteRegistrato(String nome, String cognome, String username, String password, String codiceFiscale, String tokenRegistrato) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.codiceFiscale = codiceFiscale;
        this.tokenRegistrato = tokenRegistrato;
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
        return "UtenteRegistrato{" + "nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password=" + password + ", codiceFiscale=" + codiceFiscale + ", tokenRegistrato=" + tokenRegistrato + '}';
    }

}
