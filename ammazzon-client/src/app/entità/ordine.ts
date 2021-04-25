import { Data } from '@angular/router';
import { QtaOrdineVariante } from './qta-ordine-variante';

export class Ordine {
    id: number;
    data: Data;
    numero: number;
    stato: string;
}
