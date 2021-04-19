import { Prodotto } from "../entità/prodotto";

export class Page{
    content: Prodotto[]; // <--- personalizzare
    totalPages : number;
    totalElements: number;
    last: boolean;
    size: number;
    number : number;
    sort: boolean;
    first:boolean;
    numberOfElements: number;
}