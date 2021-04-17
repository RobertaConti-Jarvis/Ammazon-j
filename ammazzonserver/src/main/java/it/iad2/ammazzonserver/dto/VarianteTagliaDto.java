package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.VarianteTaglia;

public class VarianteTagliaDto {

    private VarianteTaglia taglia;

    public VarianteTagliaDto() {
    }

    public VarianteTagliaDto(VarianteTaglia taglia) {
        this.taglia = taglia;
    }

    public VarianteTaglia getTaglia() {
        return taglia;
    }

    public void setTaglia(VarianteTaglia taglia) {
        this.taglia = taglia;
    }

}
