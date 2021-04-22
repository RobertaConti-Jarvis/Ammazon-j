package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.ColoreTaglia;

public class GestioneCarrelloDto extends ColoreTagliaDto{

    private String token;

    public GestioneCarrelloDto() {
    }

    public GestioneCarrelloDto(String token, ColoreTaglia coloreTaglia) {
        super(coloreTaglia);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
