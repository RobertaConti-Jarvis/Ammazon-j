import { ColoreTaglia } from "../entità/colore-taglia";
import { BaseRequestDto } from "./base-request-dto";

export class ColoreTagliaDto extends BaseRequestDto{
    coloreTaglia: ColoreTaglia;
}