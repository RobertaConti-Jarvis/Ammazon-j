package it.iad2.ammazzonserver.dto;

public class CriterioDatiPageDto {
    private int numPag;
    private int elemPag;
    private String criterio;

    public CriterioDatiPageDto() {
    }

    public CriterioDatiPageDto(int numPag, int elemPag, String criterio) {
        this.numPag = numPag;
        this.elemPag = elemPag;
        this.criterio = criterio;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public int getElemPag() {
        return elemPag;
    }

    public void setElemPag(int elemPag) {
        this.elemPag = elemPag;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    @Override
    public String toString() {
        return "CriterioDatiPageDto{" +
                "numPag=" + numPag +
                ", elemPag=" + elemPag +
                ", criterio='" + criterio + '\'' +
                '}';
    }
}
