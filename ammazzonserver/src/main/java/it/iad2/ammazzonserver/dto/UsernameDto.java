package it.iad2.ammazzonserver.dto;

public class UsernameDto {
    private String username;

    public UsernameDto() {
    }

    public UsernameDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UsernameDto{" + "username=" + username + '}';
    }
    
    
    
}
