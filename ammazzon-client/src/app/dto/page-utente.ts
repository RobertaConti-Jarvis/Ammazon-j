import { UtenteRegistrato } from "../entità/utente-registrato";

export class PageUtente {
    content: UtenteRegistrato[];
    totalPages: number;
    totalElements: number;
    last: boolean;
    size: number;
    number: number;
    sort: boolean;
    first: boolean;
    numberOfElements: number;
}