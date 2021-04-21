import { Ordine } from "../entità/ordine";

export class PageOrdine{
    content: Ordine[]; // <--- personalizzare
    totalPages : number;
    totalElements: number;
    last: boolean;
    size: number;
    number : number;
    sort: boolean;
    first:boolean;
    numberOfElements: number;
}