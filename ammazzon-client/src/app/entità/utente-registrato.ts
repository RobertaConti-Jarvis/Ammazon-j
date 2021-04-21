import { UtenteAnonimo } from "./utente-anonimo";

export class UtenteRegistrato extends UtenteAnonimo{
    nome: string;
    cognome: string;
    username: string;
    password: string;
    codiceFiscale: string;
    tokenRegistrato: string;
    email: string;
}