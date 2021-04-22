import { UtenteRegistrato } from "../entità/utente-registrato";
import { BaseRequestDto } from "./base-request-dto";

export class UtenteRegistratoDto extends BaseRequestDto{
    utenteRegistrato: UtenteRegistrato;
}