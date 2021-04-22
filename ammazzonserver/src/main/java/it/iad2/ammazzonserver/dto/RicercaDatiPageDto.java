/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.ammazzonserver.dto;

/**
 *
 * @author user
 */
public class RicercaDatiPageDto extends DatiPageDto{
    
    private String criterio;
    
    public RicercaDatiPageDto() {

    }

    public RicercaDatiPageDto(String criterio) {
        this.criterio = criterio;
    }

    public RicercaDatiPageDto(String criterio, int numPag, int elemPag) {
        super(numPag, elemPag);
        this.criterio = criterio;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }
    
    
}
