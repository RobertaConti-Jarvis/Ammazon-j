package it.iad2.ammazzonserver.dto;

import it.iad2.ammazzonserver.model.ColoreTaglia;

public class ColoreTagliaDto extends BaseRequestDto {

    private ColoreTaglia coloreTaglia;

    public ColoreTagliaDto() {
    }

    public ColoreTagliaDto(ColoreTaglia coloreTaglia) {
        this.coloreTaglia = coloreTaglia;
    }

    public ColoreTagliaDto(ColoreTaglia coloreTaglia, String sessionToken) {
        super(sessionToken);
        this.coloreTaglia = coloreTaglia;
    }

    public ColoreTaglia getColoreTaglia() {
        return coloreTaglia;
    }

    public void setColoreTaglia(ColoreTaglia coloreTaglia) {
        this.coloreTaglia = coloreTaglia;
    }

}
