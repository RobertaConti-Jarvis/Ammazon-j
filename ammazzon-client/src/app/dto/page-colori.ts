import { VarianteColore } from "../entità/variante-colore";

export class PageColori{
    content: VarianteColore[]; // <--- personalizzare
    totalPages : number;
    totalElements: number;
    last: boolean;
    size: number;
    number : number;
    sort: boolean;
    first:boolean;
    numberOfElements: number;
}