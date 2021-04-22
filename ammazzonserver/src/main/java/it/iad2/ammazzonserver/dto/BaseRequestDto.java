package it.iad2.ammazzonserver.dto;

public class BaseRequestDto {

    private String sessionToken = null;

    public BaseRequestDto() {
    }

    public BaseRequestDto(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

}
