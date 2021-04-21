/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.Ordine;
import org.springframework.data.domain.Page;

/**
 *
 * @author matte
 */
public class PageOrdineDto {

    Page<Ordine> listaElemPag;

    public PageOrdineDto() {
    }

    public PageOrdineDto(Page<Ordine> listaElemPag) {
        this.listaElemPag = listaElemPag;
    }

    public Page<Ordine> getListaElemPag() {
        return listaElemPag;
    }

    public void setListaElemPag(Page<Ordine> listaElemPag) {
        this.listaElemPag = listaElemPag;
    }

    @Override
    public String toString() {
        return "PageOrdineDto{" + "listaElemPag=" + listaElemPag + '}';
    }

}
