import { UtenteRegistrato } from "../entità/utente-registrato";
import { BaseRequestDto } from "./base-request-dto";

export class EsitoUtenteDto extends BaseRequestDto{
    esito : boolean;
    utenteReg : UtenteRegistrato;
}